package in.alfaaz.foundation.blog.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;
}
