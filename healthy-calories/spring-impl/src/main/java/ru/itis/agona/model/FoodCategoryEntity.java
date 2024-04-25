package ru.itis.agona.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.itis.agona.model.jpa.FoodJpaEntity;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Data
@javax.persistence.Entity
@Table(name = "food_categories")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategoryEntity extends Entity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<FoodJpaEntity> foods;

}
