package ru.itis.agona.repository.eatenFood;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.EatenFoodEntity;
import ru.itis.agona.model.jooq.schema.tables.records.EatenFoodsRecord;
import ru.itis.agona.model.jooq.schema.tables.records.UsersRecord;

import java.util.*;

import static ru.itis.agona.model.jooq.schema.Tables.EATEN_FOODS_ENTITY;

@Repository
@Primary
@RequiredArgsConstructor
public class EatenFoodJooqRepository implements EatenFoodRepository {

    private final DSLContext dsl;


    @Override
    public Set<UUID> save(List<EatenFoodEntity> eatenFoodEntities) {

        Set<UUID> ids = new HashSet<>();

        for (EatenFoodEntity eatenFood : eatenFoodEntities) {

            EatenFoodsRecord record = dsl.newRecord(EATEN_FOODS_ENTITY);
            record.setId(UUID.randomUUID());
            record.setUserId(eatenFood.getUserId());
            record.setFoodId(eatenFood.getFoodId());
            record.setWeight(eatenFood.getWeight());

            dsl.batchInsert(record).execute();

            ids.add(record.getId());

        }

        return ids;

    }

    @Override
    public Optional<EatenFoodEntity> findById(UUID id) {
        return Optional.of(Objects.requireNonNull(dsl.fetchOne(EATEN_FOODS_ENTITY, EATEN_FOODS_ENTITY.ID.eq(id)))
                .into(EatenFoodEntity.class));
    }

    @Override
    public List<EatenFoodEntity> findAll() {
        return new ArrayList<>(dsl.select().from(EATEN_FOODS_ENTITY).fetch().into(EatenFoodEntity.class));
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(EATEN_FOODS_ENTITY).where(EATEN_FOODS_ENTITY.ID.eq(id)).execute();
    }

    @Override
    public void putById(UUID id, EatenFoodEntity eatenFood) {
        UsersRecord record = new UsersRecord();
        record.from(eatenFood);
        dsl.update(EATEN_FOODS_ENTITY).set(record).where(EATEN_FOODS_ENTITY.ID.eq(id)).execute();
    }
}
