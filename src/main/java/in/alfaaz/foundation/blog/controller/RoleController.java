package in.alfaaz.foundation.blog.controller;


import in.alfaaz.foundation.blog.dto.RoleDto;
import in.alfaaz.foundation.blog.entity.RoleEntity;
import in.alfaaz.foundation.blog.services.RoleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleDataService roleDataService;

    @RequestMapping(method = RequestMethod.GET,value = "/roles")
    public List<RoleEntity> getAllRoles(){
        return roleDataService.findAll();
    }
}
