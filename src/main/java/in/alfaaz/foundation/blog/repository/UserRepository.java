package in.alfaaz.foundation.blog.repository;

import in.alfaaz.foundation.blog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query(value = "select * from alf_user users,alf_role roles where roles.ROLE_NAME = 'ADMIN' ", nativeQuery = true)
    public List<UserEntity> getAdmins();

    public UserEntity findByEmail(String email);

    public Optional<UserEntity> findById(UUID id);

    @Transactional
    @Modifying
    @Query("update UserEntity u set u.firstName = :firstName,u.lastName=:lastName,u.facebook=:facebook,u.instagram=:instagram,u.youtube=:youtube,u.twitter=:twitter WHERE u.email = :username")
    void updateAdminSettings(String username, String firstName,String lastName, String facebook, String instagram, String youtube, String twitter);
}
