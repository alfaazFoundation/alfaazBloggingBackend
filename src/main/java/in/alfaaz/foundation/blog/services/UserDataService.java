package in.alfaaz.foundation.blog.services;

import in.alfaaz.foundation.blog.dto.UserDto;
import in.alfaaz.foundation.blog.entity.UserEntity;
import in.alfaaz.foundation.blog.enums.UserRole;
import in.alfaaz.foundation.blog.repository.RoleRepository;
import in.alfaaz.foundation.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserDataService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserEntity> getAdmins(){

        return userRepository.getAdmins();
    }

    public UUID saveAdmin(UserDto adminDto){
        UserEntity admin = new UserEntity();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setEmail(adminDto.getEmail());


        admin.setPassword(bCryptPasswordEncoder.encode(adminDto.getPassword()));

        admin.setRole(roleRepository.findByRoleName(UserRole.ADMIN.toString()));

        try{
            return userRepository.save(admin).getId();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username);
        if(userEntity !=null){
            return new User(userEntity.getEmail(),userEntity.getPassword(), Collections.emptyList());
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
