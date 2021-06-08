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
    @JsonIgnore
    private Long id;

    private String title;

    private String content;

    @JsonIgnore
    private Date publishedOn;

    @JsonIgnore
    private String publishedBy;

    private BlogStatus blogStatus;

    @JsonIgnore
    private Date lastUpdated;
}
