package ru.itis.agona.exception.badRequest;

public class UserBadRequestException extends BadRequestServiceException {
    public UserBadRequestException() {
        super("Bad User-create request");
    }
}
