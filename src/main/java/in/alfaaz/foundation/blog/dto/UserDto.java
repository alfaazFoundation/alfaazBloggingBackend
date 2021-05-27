package in.alfaaz.foundation.blog.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Long id;

    private String name;

    private String username;

    private String password;
}
