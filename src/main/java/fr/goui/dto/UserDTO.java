package fr.goui.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * The data transfer object for a User.
 */
public class UserDTO {

    @Getter
    @Setter
    @NotNull
    private String nickname;

    @Getter
    @Setter
    @NotNull
    private String password;

    @Getter
    @Setter
    @Valid
    private Set<NoteDTO> notes;
}
