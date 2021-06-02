package in.alfaaz.foundation.blog.repository;

import in.alfaaz.foundation.blog.entity.BlogEntity;
import in.alfaaz.foundation.blog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

    public List<BlogEntity> findAllByUser(UserEntity userEntity);
}
