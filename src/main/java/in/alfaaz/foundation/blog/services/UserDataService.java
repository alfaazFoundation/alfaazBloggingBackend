package in.alfaaz.foundation.blog.services;

import in.alfaaz.foundation.blog.dto.UserDto;
import in.alfaaz.foundation.blog.entity.UserEntity;
import in.alfaaz.foundation.blog.enums.UserRole;
import in.alfaaz.foundation.blog.repository.RoleRepository;
import in.alfaaz.foundation.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<UserEntity> getAdmins(){

        return userRepository.getAdmins();
    }

    public Long saveAdmin(UserDto adminDto){
        UserEntity admin = new UserEntity();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());

        admin.setRole(roleRepository.findByRoleName(UserRole.ADMIN.toString()));

        return userRepository.save(admin).getId();
    }
}
