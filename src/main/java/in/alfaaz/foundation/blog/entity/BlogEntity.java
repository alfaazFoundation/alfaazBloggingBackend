package in.alfaaz.foundation.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ALF_BLOG")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "PUBLISHED_BY")
    private String publishedBy;

    @Column(name = "PUBLISHED_ON")
    private Date publishedOn;

    @ManyToOne
    private CategoryEntity category;

    @ManyToOne
    private UserEntity user;
}
