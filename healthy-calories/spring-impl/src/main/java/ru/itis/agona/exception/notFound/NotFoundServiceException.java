package ru.itis.agona.exception.notFound;

import org.springframework.http.HttpStatus;
import ru.itis.agona.exception.ServiceException;

public class NotFoundServiceException extends ServiceException {
    public NotFoundServiceException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}