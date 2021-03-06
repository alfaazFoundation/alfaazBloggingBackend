package in.alfaaz.foundation.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ALF_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FACEBOOK")
    private String facebook;

    @Column(name = "INSTAGRAM")
    private String instagram;

    @Column(name = "YOUTUBE")
    private String youtube;

    @Column(name = "TWITTER")
    private String twitter;

    @Column(name = "EMAIL",unique = true)
    private String email;

    @ManyToOne
    private RoleEntity role;

    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL, orphanRemoval = true,
    mappedBy = "user")
    private List<BlogEntity> blogEntities;
}
