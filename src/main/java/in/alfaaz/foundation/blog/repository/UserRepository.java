package in.alfaaz.foundation.blog.repository;

import in.alfaaz.foundation.blog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select * from alf_user users,alf_role roles where roles.ROLE_NAME = 'ADMIN' ", nativeQuery = true)
    public List<UserEntity> getAdmins();
}
