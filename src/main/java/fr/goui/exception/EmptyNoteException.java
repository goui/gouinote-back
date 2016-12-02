package fr.goui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a user tries to add an empty note.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "The note is empty")
public class EmptyNoteException extends Exception {
}
