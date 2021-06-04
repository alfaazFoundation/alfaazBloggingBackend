package in.alfaaz.foundation.blog.controller;

import in.alfaaz.foundation.blog.dto.UserDto;
import in.alfaaz.foundation.blog.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserDataService userDataService;

    @RequestMapping(method = RequestMethod.POST, value = "/user/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){
      return new ResponseEntity<String>(userDataService.register(userDto).toString(), HttpStatus.OK);
    }
}
