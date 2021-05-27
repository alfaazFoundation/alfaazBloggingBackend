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

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
    private RoleEntity role;

    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL, orphanRemoval = true,
    mappedBy = "user")
    private List<BlogEntity> blogEntities = new ArrayList<>();
}
