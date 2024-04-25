package ru.itis.agona.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import ru.itis.agona.model.jpa.FoodJpaEntity;
import ru.itis.agona.model.jpa.UserJpaEntity;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Data
@javax.persistence.Entity
@Table(name = "eaten_foods")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EatenFoodEntity extends Entity {

    private UUID userId;

    private UUID foodId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodEntity food;

    @Column(nullable = false, unique = false)
    private Short weight;

    @CreationTimestamp
    @Column(name = "created_date")
    private Instant createdDate;

}
