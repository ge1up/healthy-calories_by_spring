package ru.itis.agona.repository.foodCategory;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FoodCategoryEntity;
import ru.itis.agona.model.jooq.schema.tables.records.FoodCategoriesRecord;
import ru.itis.agona.model.jooq.schema.tables.records.UsersRecord;

import java.util.*;

import static ru.itis.agona.model.jooq.schema.Tables.FOOD_CATEGORIES_ENTITY;

@Repository
@RequiredArgsConstructor
public class FoodCategoryJooqRepository implements FoodCategoryRepository {

    private final DSLContext dsl;


    @Override
    public Set<UUID> save(List<FoodCategoryEntity> foodCategoryEntities) {
        Set<UUID> ids = new HashSet<>();

        for (FoodCategoryEntity foodCategory : foodCategoryEntities) {

            FoodCategoriesRecord record = dsl.newRecord(FOOD_CATEGORIES_ENTITY);
            record.setId(UUID.randomUUID());
            record.setName(foodCategory.getName());

            dsl.batchInsert(record).execute();

            ids.add(record.getId());

        }

        return ids;
    }

    @Override
    public Optional<FoodCategoryEntity> findById(UUID id) {
        return Optional.of(Objects.requireNonNull(dsl.fetchOne(FOOD_CATEGORIES_ENTITY, FOOD_CATEGORIES_ENTITY.ID.eq(id)))
                .into(FoodCategoryEntity.class));
    }

    @Override
    public List<FoodCategoryEntity> findAll() {
        return new ArrayList<>(dsl.select().from(FOOD_CATEGORIES_ENTITY).fetch().into(FoodCategoryEntity.class));
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(FOOD_CATEGORIES_ENTITY).where(FOOD_CATEGORIES_ENTITY.ID.eq(id)).execute();
    }

    @Override
    public void putById(UUID id, FoodCategoryEntity foodCategory) {
        UsersRecord record = new UsersRecord();
        record.from(foodCategory);
        dsl.update(FOOD_CATEGORIES_ENTITY).set(record).where(FOOD_CATEGORIES_ENTITY.ID.eq(id)).execute();
    }
}
