package in.alfaaz.foundation.blog.controller;


import in.alfaaz.foundation.blog.dto.UserDto;
import in.alfaaz.foundation.blog.entity.UserEntity;
import in.alfaaz.foundation.blog.services.UserDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdminController {

    @Autowired
    private UserDataService userDataService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/admins",produces = "application/json")
    public List<UserDto> getAdmins(){
        return userDataService.getAdmins().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/admins")
    public Long addAdmin(@RequestBody UserDto admin){
        return userDataService.saveAdmin(admin);
    }

    private UserDto convertToDto(UserEntity userEntity){
        return modelMapper.map(userEntity,UserDto.class);
    }
}
