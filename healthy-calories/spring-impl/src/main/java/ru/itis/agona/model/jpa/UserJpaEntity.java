package ru.itis.agona.model.jpa;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "users")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserJpaEntity extends AbstractEntity {

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private String surname;

    @Column(nullable = false, unique = false)
    private Short age;

    @Column(nullable = false, unique = false)
    private Short weight;

    @Column(nullable = false, unique = false)
    private Short height;

    @Column(name = "type_of_food", nullable = false, unique = false)
    private Short typeOfFood;

    @OneToOne(mappedBy = "user")
    private FavoriteDishJpaEntity favoriteDish;

    @OneToMany(mappedBy = "user")
    private List<EatenFoodJpaEntity> eatenFoods;

}
