package in.alfaaz.foundation.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    @JsonIgnore
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;
}
