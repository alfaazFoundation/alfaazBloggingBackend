package in.alfaaz.foundation.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ALF_CATEGORY")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL, orphanRemoval = true,
    mappedBy = "category")
    List<BlogEntity> blogEntities = new ArrayList<>();
}
