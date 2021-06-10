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

    @Column(name = "PUBLISHED_ON", nullable = false, updatable = false)
    @CreationTimestamp
    private Date publishedOn;

    @Column(name = "BLOG_STATUS")
    @Enumerated(EnumType.STRING)
    private BlogStatus blogStatus;

    @Column(name = "LAST_UPDATED")
    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Override
    public String toString() {
        return "BlogEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishedBy='" + publishedBy + '\'' +
                ", publishedOn=" + publishedOn +
                ", blogStatus=" + blogStatus +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
