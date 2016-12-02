package fr.goui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when the nickname or the password is wrong.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Wrong credentials")
public class WrongCredentialsException extends Exception {
}
