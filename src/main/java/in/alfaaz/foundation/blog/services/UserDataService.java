package in.alfaaz.foundation.blog.services;

import in.alfaaz.foundation.blog.entity.UserEntity;
import in.alfaaz.foundation.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAdmins(){
        return userRepository.getAdmins();
    }
}
