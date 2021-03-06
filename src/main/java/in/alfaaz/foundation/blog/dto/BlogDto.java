package in.alfaaz.foundation.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.alfaaz.foundation.blog.enums.BlogStatus;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BlogDto {
    private Long id;

    private String title;

    private String content;


    private Date publishedOn;

    private String publishedBy;

    private BlogStatus blogStatus;

    @JsonIgnore
    private Date lastUpdated;
}
