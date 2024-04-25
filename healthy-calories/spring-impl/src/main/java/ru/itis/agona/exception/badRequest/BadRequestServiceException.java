package ru.itis.agona.exception.badRequest;

import org.springframework.http.HttpStatus;
import ru.itis.agona.exception.ServiceException;

public class BadRequestServiceException extends ServiceException {
    public BadRequestServiceException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
