package in.alfaaz.foundation.blog.controller;


import in.alfaaz.foundation.blog.entity.UserEntity;
import in.alfaaz.foundation.blog.repository.UserRepository;
import in.alfaaz.foundation.blog.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/a")
public class AdminController {

    @Autowired
    private UserDataService userDataService;

    @GetMapping(value = "/admins",produces = "application/json")
    public List<UserEntity> getAdmins(){
        return userDataService.getAdmins();
    }

    @PostMapping(value = "/admins")
    public Integer addAdmin(UserEntity admin){
        return 0;
//        return userDataService.save(admin).getId();
    }
}
