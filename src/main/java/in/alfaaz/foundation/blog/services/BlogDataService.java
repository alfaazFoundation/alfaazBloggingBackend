package in.alfaaz.foundation.blog.services;

import in.alfaaz.foundation.blog.dto.BlogDto;
import in.alfaaz.foundation.blog.entity.BlogEntity;
import in.alfaaz.foundation.blog.entity.UserEntity;
import in.alfaaz.foundation.blog.enums.BlogStatus;
import in.alfaaz.foundation.blog.repository.BlogRepository;
import in.alfaaz.foundation.blog.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogDataService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<BlogEntity> findAll(){
        return blogRepository.findAll();
    }

    public long addOne(BlogDto blogDto){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername());
        BlogEntity blogEntity = new BlogEntity();
        if(Objects.nonNull(blogDto.getId()))
            blogEntity.setId(blogDto.getId());
        blogEntity.setTitle(blogDto.getTitle());
        blogEntity.setContent(blogDto.getContent());
        String publishedBy = userEntity.getFirstName() + " " + userEntity.getLastName();
        blogEntity.setPublishedBy(publishedBy);
        blogEntity.setBlogStatus(blogDto.getBlogStatus());
        blogEntity.setUser(userEntity);

        return blogRepository.save(blogEntity).getId();
    }

    public List<BlogDto> findBlogByUser(String username){
        UserEntity userEntity = userRepository.findByEmail(username);
        List<BlogEntity> blogEntities= blogRepository.findAllByUser(userEntity.getId());
        List<BlogDto> blogDtos = blogEntities.stream()
                .map(blogEntity -> modelMapper.map(blogEntity, BlogDto.class))
                .collect(Collectors.toList());
        blogDtos.forEach(blogDto -> blogDto.setPublishedBy(userEntity.getFirstName() + " " + userEntity.getLastName()));
        return blogDtos;
    }

    public List<BlogDto> getPublsihedBlogs(){
        List<BlogEntity> blogEntities = blogRepository.findByBlogStatus(BlogStatus.PUBLISHED);
        blogEntities.stream().forEach(blogEntity -> {
            UserEntity userEntity = blogEntity.getUser();
            blogEntity.setPublishedBy(userEntity.getFirstName() + " " + userEntity.getLastName());
        });
        List<BlogDto> blogDtos = blogEntities.stream()
                .map(blogEntity -> modelMapper.map(blogEntity, BlogDto.class))
                .collect(Collectors.toList());
        return blogDtos;
    }
}
