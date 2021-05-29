package in.alfaaz.foundation.blog.repository;

import in.alfaaz.foundation.blog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select users from ALF_USER users,ALF_ROLE roles where users.id=roles.id and roles.ROLE_NAME = 'ADMIN' ", nativeQuery = true)
    public List<UserEntity> getAdmins();
}
