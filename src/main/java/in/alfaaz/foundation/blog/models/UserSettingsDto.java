package in.alfaaz.foundation.blog.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSettingsDto {

    private String username;

    private String firstName;

    private String lastName;

    private String instagram;

    private String facebook;

    private String twitter;

    private String youtube;

    private String password;
}
