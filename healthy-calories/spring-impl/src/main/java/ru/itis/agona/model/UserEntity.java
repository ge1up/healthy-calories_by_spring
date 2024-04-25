package ru.itis.agona.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.itis.agona.model.jpa.EatenFoodJpaEntity;
import ru.itis.agona.model.jpa.FavoriteDishJpaEntity;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@javax.persistence.Entity
@Table(name = "users")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends Entity {

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
