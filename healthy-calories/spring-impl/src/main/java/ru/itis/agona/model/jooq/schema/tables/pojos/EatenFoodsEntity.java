/*
 * This file is generated by jOOQ.
 */
package ru.itis.agona.model.jooq.schema.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import ru.itis.agona.model.Entity;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EatenFoodsEntity extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private UUID userId;
    private UUID foodId;
    private Short weight;
    private LocalDateTime createdDate;

    public EatenFoodsEntity() {}

    public EatenFoodsEntity(EatenFoodsEntity value) {
        this.id = value.id;
        this.userId = value.userId;
        this.foodId = value.foodId;
        this.weight = value.weight;
        this.createdDate = value.createdDate;
    }

    public EatenFoodsEntity(
        UUID id,
        UUID userId,
        UUID foodId,
        Short weight,
        LocalDateTime createdDate
    ) {
        this.id = id;
        this.userId = userId;
        this.foodId = foodId;
        this.weight = weight;
        this.createdDate = createdDate;
    }

    /**
     * Getter for <code>public.eaten_foods.id</code>.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.eaten_foods.id</code>.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.eaten_foods.user_id</code>.
     */
    public UUID getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.eaten_foods.user_id</code>.
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>public.eaten_foods.food_id</code>.
     */
    public UUID getFoodId() {
        return this.foodId;
    }

    /**
     * Setter for <code>public.eaten_foods.food_id</code>.
     */
    public void setFoodId(UUID foodId) {
        this.foodId = foodId;
    }

    /**
     * Getter for <code>public.eaten_foods.weight</code>.
     */
    public Short getWeight() {
        return this.weight;
    }

    /**
     * Setter for <code>public.eaten_foods.weight</code>.
     */
    public void setWeight(Short weight) {
        this.weight = weight;
    }

    /**
     * Getter for <code>public.eaten_foods.created_date</code>.
     */
    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Setter for <code>public.eaten_foods.created_date</code>.
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final EatenFoodsEntity other = (EatenFoodsEntity) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.foodId == null) {
            if (other.foodId != null)
                return false;
        }
        else if (!this.foodId.equals(other.foodId))
            return false;
        if (this.weight == null) {
            if (other.weight != null)
                return false;
        }
        else if (!this.weight.equals(other.weight))
            return false;
        if (this.createdDate == null) {
            if (other.createdDate != null)
                return false;
        }
        else if (!this.createdDate.equals(other.createdDate))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.foodId == null) ? 0 : this.foodId.hashCode());
        result = prime * result + ((this.weight == null) ? 0 : this.weight.hashCode());
        result = prime * result + ((this.createdDate == null) ? 0 : this.createdDate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("EatenFoodsEntity (");

        sb.append(id);
        sb.append(", ").append(userId);
        sb.append(", ").append(foodId);
        sb.append(", ").append(weight);
        sb.append(", ").append(createdDate);

        sb.append(")");
        return sb.toString();
    }
}