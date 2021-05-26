package in.alfaaz.foundation.blog.entity;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ALF_ROLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @OneToMany(mappedBy = "role",
    cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserEntity> userEntityList = new ArrayList<>();
}
