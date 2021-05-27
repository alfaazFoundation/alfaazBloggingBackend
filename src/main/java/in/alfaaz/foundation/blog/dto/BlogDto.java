package in.alfaaz.foundation.blog.dto;

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

    private String category;
}
