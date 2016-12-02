package fr.goui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when the user is trying to create an account with a nickname already present in the database.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "The nickname already exists")
public class NicknameAlreadyExistsException extends Exception {
}
