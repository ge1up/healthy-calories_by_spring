/*
 * This file is generated by jOOQ.
 */
package ru.itis.agona.model.jooq.schema.tables.pojos;


import java.io.Serializable;
import java.util.UUID;

import ru.itis.agona.model.Entity;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FoodsEntity extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private Short proteins;
    private Short fats;
    private Short carbohydrates;
    private Short caloriesNumber;
    private Short typeOfFood;
    private UUID categoryId;

    public FoodsEntity() {}

    public FoodsEntity(FoodsEntity value) {
        this.id = value.id;
        this.name = value.name;
        this.proteins = value.proteins;
        this.fats = value.fats;
        this.carbohydrates = value.carbohydrates;
        this.caloriesNumber = value.caloriesNumber;
        this.typeOfFood = value.typeOfFood;
        this.categoryId = value.categoryId;
    }

    public FoodsEntity(
        UUID id,
        String name,
        Short proteins,
        Short fats,
        Short carbohydrates,
        Short caloriesNumber,
        Short typeOfFood,
        UUID categoryId
    ) {
        this.id = id;
        this.name = name;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.caloriesNumber = caloriesNumber;
        this.typeOfFood = typeOfFood;
        this.categoryId = categoryId;
    }

    /**
     * Getter for <code>public.foods.id</code>.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.foods.id</code>.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.foods.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.foods.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.foods.proteins</code>.
     */
    public Short getProteins() {
        return this.proteins;
    }

    /**
     * Setter for <code>public.foods.proteins</code>.
     */
    public void setProteins(Short proteins) {
        this.proteins = proteins;
    }

    /**
     * Getter for <code>public.foods.fats</code>.
     */
    public Short getFats() {
        return this.fats;
    }

    /**
     * Setter for <code>public.foods.fats</code>.
     */
    public void setFats(Short fats) {
        this.fats = fats;
    }

    /**
     * Getter for <code>public.foods.carbohydrates</code>.
     */
    public Short getCarbohydrates() {
        return this.carbohydrates;
    }

    /**
     * Setter for <code>public.foods.carbohydrates</code>.
     */
    public void setCarbohydrates(Short carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    /**
     * Getter for <code>public.foods.calories_number</code>.
     */
    public Short getCaloriesNumber() {
        return this.caloriesNumber;
    }

    /**
     * Setter for <code>public.foods.calories_number</code>.
     */
    public void setCaloriesNumber(Short caloriesNumber) {
        this.caloriesNumber = caloriesNumber;
    }

    /**
     * Getter for <code>public.foods.type_of_food</code>.
     */
    public Short getTypeOfFood() {
        return this.typeOfFood;
    }

    /**
     * Setter for <code>public.foods.type_of_food</code>.
     */
    public void setTypeOfFood(Short typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    /**
     * Getter for <code>public.foods.category_id</code>.
     */
    public UUID getCategoryId() {
        return this.categoryId;
    }

    /**
     * Setter for <code>public.foods.category_id</code>.
     */
    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final FoodsEntity other = (FoodsEntity) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.proteins == null) {
            if (other.proteins != null)
                return false;
        }
        else if (!this.proteins.equals(other.proteins))
            return false;
        if (this.fats == null) {
            if (other.fats != null)
                return false;
        }
        else if (!this.fats.equals(other.fats))
            return false;
        if (this.carbohydrates == null) {
            if (other.carbohydrates != null)
                return false;
        }
        else if (!this.carbohydrates.equals(other.carbohydrates))
            return false;
        if (this.caloriesNumber == null) {
            if (other.caloriesNumber != null)
                return false;
        }
        else if (!this.caloriesNumber.equals(other.caloriesNumber))
            return false;
        if (this.typeOfFood == null) {
            if (other.typeOfFood != null)
                return false;
        }
        else if (!this.typeOfFood.equals(other.typeOfFood))
            return false;
        if (this.categoryId == null) {
            if (other.categoryId != null)
                return false;
        }
        else if (!this.categoryId.equals(other.categoryId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.proteins == null) ? 0 : this.proteins.hashCode());
        result = prime * result + ((this.fats == null) ? 0 : this.fats.hashCode());
        result = prime * result + ((this.carbohydrates == null) ? 0 : this.carbohydrates.hashCode());
        result = prime * result + ((this.caloriesNumber == null) ? 0 : this.caloriesNumber.hashCode());
        result = prime * result + ((this.typeOfFood == null) ? 0 : this.typeOfFood.hashCode());
        result = prime * result + ((this.categoryId == null) ? 0 : this.categoryId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FoodsEntity (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(proteins);
        sb.append(", ").append(fats);
        sb.append(", ").append(carbohydrates);
        sb.append(", ").append(caloriesNumber);
        sb.append(", ").append(typeOfFood);
        sb.append(", ").append(categoryId);

        sb.append(")");
        return sb.toString();
    }
}
