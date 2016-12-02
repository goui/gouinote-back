package fr.goui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when the nickname is not present in the database.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This account doesn't exist")
public class NicknameNotFoundException extends Exception {
}
