package ru.itis.agona.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "eaten_foods")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EatenFoodJpaEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserJpaEntity user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodJpaEntity food;

    @Column(nullable = false, unique = false)
    private Short weight;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, unique = false)
    private Instant createdDate;

}
