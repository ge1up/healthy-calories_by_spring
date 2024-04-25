package ru.itis.agona.exception.badRequest;

public class FoodBadRequestException extends BadRequestServiceException {
    public FoodBadRequestException() {
        super("Bad Food-create request");
    }
}
