package ru.itis.agona.exception.badRequest;

public class FoodCategoryBadRequestException extends BadRequestServiceException {
    public FoodCategoryBadRequestException() {
        super("Bad Food-Category-create request");
    }
}
