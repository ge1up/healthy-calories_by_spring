package ru.itis.agona.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "foods")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FoodJpaEntity extends AbstractEntity {

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private Short proteins;

    @Column(nullable = false, unique = false)
    private Short fats;

    @Column(nullable = false, unique = false)
    private Short carbohydrates;

    @Column(name = "calories_number", nullable = false, unique = false)
    private Short caloriesNumber;

    @Column(name = "type_of_food", nullable = false, unique = false)
    private Short typeOfFood;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, unique = false)
    private FoodCategorieJpaEntity category;

    @OneToMany(mappedBy = "food")
    private List<EatenFoodJpaEntity> users;

}
