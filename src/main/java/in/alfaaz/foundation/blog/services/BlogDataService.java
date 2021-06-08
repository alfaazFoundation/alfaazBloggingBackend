package in.alfaaz.foundation.blog.services;

import in.alfaaz.foundation.blog.dto.BlogDto;
import in.alfaaz.foundation.blog.entity.BlogEntity;
import in.alfaaz.foundation.blog.entity.UserEntity;
import in.alfaaz.foundation.blog.repository.BlogRepository;
import in.alfaaz.foundation.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogDataService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;

    public List<BlogEntity> findAll(){
        return blogRepository.findAll();
    }

    public long addOne(BlogDto blogDto){
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setTitle(blogDto.getTitle());
        blogEntity.setContent(blogDto.getContent());
        blogEntity.setPublishedOn(blogDto.getPublishedOn());
        blogEntity.setPublishedBy(blogDto.getPublishedBy());

        return blogRepository.save(blogEntity).getId();
    }

    public List<BlogEntity> findBlogByUser(String username){
        UserEntity userEntity = userRepository.findByEmail(username);
        return blogRepository.findAllByUser(userEntity);

    }
}
