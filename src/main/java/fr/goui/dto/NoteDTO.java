package fr.goui.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * The data transfer object for a Note.
 */
public class NoteDTO {

    @Getter
    @Setter
    @NotNull
    private long date;

    @Getter
    @Setter
    @NotNull
    private String content;
}
