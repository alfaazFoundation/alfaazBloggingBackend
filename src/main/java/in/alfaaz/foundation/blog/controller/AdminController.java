package in.alfaaz.foundation.blog.controller;


import in.alfaaz.foundation.blog.dto.UserDto;
import in.alfaaz.foundation.blog.models.UserLoginRequest;
import in.alfaaz.foundation.blog.models.UserLoginResponse;
import in.alfaaz.foundation.blog.models.UserRegisterRequest;
import in.alfaaz.foundation.blog.models.UserSettingsDto;
import in.alfaaz.foundation.blog.services.UserDataService;
import in.alfaaz.foundation.blog.utils.JwtTokenUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class AdminController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JwtTokenUtils jwtTokenUtil;

    @GetMapping(value = "/admins",produces = "application/json")
    public List<UserDto> getAdmins(){
        return userDataService.getAdmins().stream()
                .map(userEntity -> modelMapper.map(userEntity,UserDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/public/admins")
    public ResponseEntity<String> addAdmin(@RequestBody @Valid UserRegisterRequest admin){
        try{
            return new ResponseEntity<String>(userDataService.saveAdmin(admin).toString(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/public/admins/login")
    public ResponseEntity<UserLoginResponse> loginAdmin(@RequestBody UserLoginRequest userLoginRequest){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginRequest.getUsername(),userLoginRequest.getPassword())
            );
        }catch (Exception e){
            throw e;
        }

        User admin = (User) userDataService.loadUserByUsername(userLoginRequest.getUsername());
        String token = jwtTokenUtil.generateTokenByUsername(admin.getUsername());
        UserLoginResponse response = new UserLoginResponse();
        response.setToken(token);
        response.setStatus("OK");
        response.setCode(200);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/admins/settings")
    public ResponseEntity<String> updateSettings(@RequestBody UserSettingsDto userSettingsDto, @RequestHeader (name="Authorization") String tokenHeader){
        try{
            String username = jwtTokenUtil.getUsernameFromHeader(tokenHeader);
            userSettingsDto.setUsername(username);
            return new ResponseEntity<String>(userDataService.updateAdminSettings(userSettingsDto),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
