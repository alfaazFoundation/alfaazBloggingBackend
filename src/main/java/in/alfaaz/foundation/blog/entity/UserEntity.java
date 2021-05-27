package in.alfaaz.foundation.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ALF_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToOne
    private RoleEntity role;

    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL, orphanRemoval = true,
    mappedBy = "user")
    private List<BlogEntity> blogEntities = new ArrayList<>();
}
