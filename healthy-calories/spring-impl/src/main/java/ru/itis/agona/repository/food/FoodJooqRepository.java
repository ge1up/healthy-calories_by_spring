package ru.itis.agona.repository.food;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FoodEntity;
import ru.itis.agona.model.jooq.schema.tables.records.FoodsRecord;
import ru.itis.agona.model.jooq.schema.tables.records.UsersRecord;

import java.util.*;

import static ru.itis.agona.model.jooq.schema.Tables.FOODS_ENTITY;

@Repository
@RequiredArgsConstructor
public class FoodJooqRepository implements FoodRepository {

    private final DSLContext dsl;

    @Override
    public Set<UUID> save(List<FoodEntity> foodEntities) {

        Set<UUID> ids = new HashSet<>();

        for (FoodEntity food : foodEntities) {

            FoodsRecord record = dsl.newRecord(FOODS_ENTITY);
            record.setId(UUID.randomUUID());
            record.setName(food.getName());
            record.setProteins(food.getProteins());
            record.setFats(food.getFats());
            record.setCarbohydrates(food.getCarbohydrates());
            record.setCaloriesNumber(food.getCaloriesNumber());
            record.setTypeOfFood(food.getTypeOfFood());
            record.setCategoryId(food.getCategoryId());

            dsl.batchInsert(record).execute();

            ids.add(record.getId());

        }

        return ids;

    }

    @Override
    public Optional<FoodEntity> findById(UUID id) {
        return Optional.of(Objects.requireNonNull(dsl.fetchOne(FOODS_ENTITY, FOODS_ENTITY.ID.eq(id)))
                .into(FoodEntity.class));
    }

    @Override
    public List<FoodEntity> findAll() {
        return new ArrayList<>(dsl.select().from(FOODS_ENTITY).fetch().into(FoodEntity.class));
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(FOODS_ENTITY).where(FOODS_ENTITY.ID.eq(id)).execute();
    }

    @Override
    public void putById(UUID id, FoodEntity food) {
        UsersRecord record = new UsersRecord();
        record.from(food);
        dsl.update(FOODS_ENTITY).set(record).where(FOODS_ENTITY.ID.eq(id)).execute();
    }

}
