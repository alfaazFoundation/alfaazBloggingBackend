package in.alfaaz.foundation.blog.controller;


import in.alfaaz.foundation.blog.dto.UserDto;
import in.alfaaz.foundation.blog.entity.UserEntity;
import in.alfaaz.foundation.blog.services.UserDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class AdminController {

    @Autowired
    private UserDataService userDataService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/admins",produces = "application/json")
    public List<UserDto> getAdmins(){
        return userDataService.getAdmins().stream()
                .map(userEntity -> modelMapper.map(userEntity,UserDto.class))
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
