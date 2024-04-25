package ru.itis.agona.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "food_categories")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FoodCategorieJpaEntity extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<FoodJpaEntity> foods;

}
