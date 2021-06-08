package in.alfaaz.foundation.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String facebook;

    private String instagram;

    private String youtube;

    private String twitter;

    @JsonIgnore
    private String password;

    private String role;
}
