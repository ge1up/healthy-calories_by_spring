package ru.itis.agona.exception.badRequest;

public class FavoriteDishBadRequestException extends BadRequestServiceException {
    public FavoriteDishBadRequestException() {
        super("Bad Favorite-Dish-create request");
    }
}
