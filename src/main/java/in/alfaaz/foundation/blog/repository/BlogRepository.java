package in.alfaaz.foundation.blog.repository;

import in.alfaaz.foundation.blog.entity.BlogEntity;
import in.alfaaz.foundation.blog.entity.UserEntity;
import in.alfaaz.foundation.blog.enums.BlogStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

    @Query("Select b from BlogEntity b  where b.user.id = :userId")
    public List<BlogEntity> findAllByUser(@Param("userId")UUID userId);

    public List<BlogEntity> findByBlogStatus(BlogStatus blogStatus);
}
