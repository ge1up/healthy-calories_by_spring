package ru.itis.agona.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.itis.agona.model.jpa.UserJpaEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@javax.persistence.Entity
@Table(name = "favorite_dishes")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteDishEntity extends Entity {

    private UUID userId;

    @Column(nullable = false, unique = false)
    private Short timesEaten;

    @Column(nullable = false, unique = false)
    private Short averageWeight;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserJpaEntity user;

}
