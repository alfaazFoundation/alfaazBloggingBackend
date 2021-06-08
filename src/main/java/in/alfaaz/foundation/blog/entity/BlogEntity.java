package in.alfaaz.foundation.blog.entity;

import in.alfaaz.foundation.blog.enums.BlogStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @CreationTimestamp
    private Date publishedOn;

    @Column(name = "BLOG_STATUS")
    @Enumerated(EnumType.STRING)
    private BlogStatus blogStatus;

    @Column(name = "LAST_UPDATED")
    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
