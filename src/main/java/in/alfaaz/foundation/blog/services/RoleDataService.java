package in.alfaaz.foundation.blog.services;

import in.alfaaz.foundation.blog.entity.RoleEntity;
import in.alfaaz.foundation.blog.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleDataService {
    @Autowired
    RoleRepository roleRepository;

    public List<RoleEntity> findAll(){
        return roleRepository.findAll();
    }
}
