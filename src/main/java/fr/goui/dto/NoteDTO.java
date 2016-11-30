package fr.goui.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * The data transfer object for a Note.
 */
@EqualsAndHashCode
public class NoteDTO {

    @Getter
    @Setter
    @NotNull
    private long date;

    @Getter
    @Setter
    @NotNull
    private String content;

    @Getter
    @Setter
    @NotNull
    private String nickname;
}
