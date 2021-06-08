package in.alfaaz.foundation.blog.controller;

import in.alfaaz.foundation.blog.dto.BlogDto;
import in.alfaaz.foundation.blog.services.BlogDataService;
import in.alfaaz.foundation.blog.utils.JwtTokenUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class BlogController {

    @Autowired
    BlogDataService blogDataService;
    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/blog")
    public List<BlogDto> getAllBlogs(){
        return blogDataService.findAll()
                .stream()
                .map(blogEntity-> modelMapper.map(blogEntity,BlogDto.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/blog")
    public long addNewBlog(@RequestBody BlogDto blogDto){
        return blogDataService.addOne(blogDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/blog/user")
    public List<BlogDto> getAllBlogsByUer(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return blogDataService.findBlogByUser(userDetails.getUsername())
                    .stream()
                    .map(blogEntity -> modelMapper.map(blogEntity, BlogDto.class))
                    .collect(Collectors.toList());
    }
}
