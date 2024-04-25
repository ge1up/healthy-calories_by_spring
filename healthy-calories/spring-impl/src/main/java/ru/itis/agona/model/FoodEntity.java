package ru.itis.agona.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.itis.agona.model.jpa.EatenFoodJpaEntity;
import ru.itis.agona.model.jpa.FoodCategorieJpaEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@javax.persistence.Entity
@Table(name = "foods")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FoodEntity extends Entity {

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

    private UUID categoryId;

}
