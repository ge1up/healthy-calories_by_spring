package ru.itis.agona.exception.notFound;

import java.util.UUID;

public class FavoriteDishNotFoundException extends NotFoundServiceException {
    public FavoriteDishNotFoundException(UUID id) {
        super("Favorite-Dish with id = %s - not found".formatted(id));
    }
}
