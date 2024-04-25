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
public class FavoriteDishesEntity extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private UUID userId;
    private Short timesEaten;
    private Short averageWeight;

    public FavoriteDishesEntity() {}

    public FavoriteDishesEntity(FavoriteDishesEntity value) {
        this.id = value.id;
        this.userId = value.userId;
        this.timesEaten = value.timesEaten;
        this.averageWeight = value.averageWeight;
    }

    public FavoriteDishesEntity(
        UUID id,
        UUID userId,
        Short timesEaten,
        Short averageWeight
    ) {
        this.id = id;
        this.userId = userId;
        this.timesEaten = timesEaten;
        this.averageWeight = averageWeight;
    }

    /**
     * Getter for <code>public.favorite_dishes.id</code>.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.favorite_dishes.id</code>.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.favorite_dishes.user_id</code>.
     */
    public UUID getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.favorite_dishes.user_id</code>.
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>public.favorite_dishes.times_eaten</code>.
     */
    public Short getTimesEaten() {
        return this.timesEaten;
    }

    /**
     * Setter for <code>public.favorite_dishes.times_eaten</code>.
     */
    public void setTimesEaten(Short timesEaten) {
        this.timesEaten = timesEaten;
    }

    /**
     * Getter for <code>public.favorite_dishes.average_weight</code>.
     */
    public Short getAverageWeight() {
        return this.averageWeight;
    }

    /**
     * Setter for <code>public.favorite_dishes.average_weight</code>.
     */
    public void setAverageWeight(Short averageWeight) {
        this.averageWeight = averageWeight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final FavoriteDishesEntity other = (FavoriteDishesEntity) obj;
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
        if (this.timesEaten == null) {
            if (other.timesEaten != null)
                return false;
        }
        else if (!this.timesEaten.equals(other.timesEaten))
            return false;
        if (this.averageWeight == null) {
            if (other.averageWeight != null)
                return false;
        }
        else if (!this.averageWeight.equals(other.averageWeight))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.timesEaten == null) ? 0 : this.timesEaten.hashCode());
        result = prime * result + ((this.averageWeight == null) ? 0 : this.averageWeight.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FavoriteDishesEntity (");

        sb.append(id);
        sb.append(", ").append(userId);
        sb.append(", ").append(timesEaten);
        sb.append(", ").append(averageWeight);

        sb.append(")");
        return sb.toString();
    }
}