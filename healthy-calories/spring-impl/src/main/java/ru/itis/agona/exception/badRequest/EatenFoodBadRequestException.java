package ru.itis.agona.exception.badRequest;

public class EatenFoodBadRequestException extends BadRequestServiceException {
    public EatenFoodBadRequestException() {
        super("Bad Eaten-Food-create request");
    }
}
