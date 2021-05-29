package in.alfaaz.foundation.blog.repository;

import in.alfaaz.foundation.blog.entity.RoleEntity;
import in.alfaaz.foundation.blog.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    public RoleEntity findByRoleName(String roleName);
}
