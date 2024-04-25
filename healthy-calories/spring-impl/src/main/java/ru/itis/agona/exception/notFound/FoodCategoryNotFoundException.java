package ru.itis.agona.exception.notFound;

import java.util.UUID;

public class FoodCategoryNotFoundException extends NotFoundServiceException {
    public FoodCategoryNotFoundException(UUID id) {
        super("Food-Category with id = %s - not found".formatted(id));
    }
}
