package ru.itis.agona.exception.notFound;

import java.util.UUID;

public class FoodNotFoundException extends NotFoundServiceException {
    public FoodNotFoundException(UUID id) {
        super("Food with id = %s - not found".formatted(id));
    }
}
