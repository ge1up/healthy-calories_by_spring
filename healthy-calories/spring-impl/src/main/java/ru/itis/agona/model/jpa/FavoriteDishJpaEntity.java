package ru.itis.agona.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "favorite_dishes")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDishJpaEntity extends AbstractEntity {

    @Column()
    private Short timesEaten;

    private Short averageWeight;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserJpaEntity user;

}
