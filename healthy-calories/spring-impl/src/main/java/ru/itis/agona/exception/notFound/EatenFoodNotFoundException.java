package ru.itis.agona.exception.notFound;

import java.util.UUID;

public class EatenFoodNotFoundException extends NotFoundServiceException {
    public EatenFoodNotFoundException(UUID id) {
        super("Eaten-Food with id = %s - not found".formatted(id));
    }
}
