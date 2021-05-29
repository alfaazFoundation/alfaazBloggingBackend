package in.alfaaz.foundation.blog.controller;

import in.alfaaz.foundation.blog.dto.BlogDto;
import in.alfaaz.foundation.blog.services.BlogDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

}
