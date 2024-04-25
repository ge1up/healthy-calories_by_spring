package ru.itis.agona.repository.favoriteDish;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FavoriteDishEntity;
import ru.itis.agona.model.jooq.schema.tables.records.FavoriteDishesRecord;
import ru.itis.agona.model.jooq.schema.tables.records.UsersRecord;

import java.util.*;

import static ru.itis.agona.model.jooq.schema.Tables.FAVORITE_DISHES_ENTITY;

@Repository
@RequiredArgsConstructor
public class FavoriteDishJooqRepository implements FavoriteDishRepository {

    private final DSLContext dsl;


    @Override
    public Set<UUID> save(List<FavoriteDishEntity> favoriteDishEntities) {

        Set<UUID> ids = new HashSet<>();

        for (FavoriteDishEntity favoriteDish : favoriteDishEntities) {

            FavoriteDishesRecord record = dsl.newRecord(FAVORITE_DISHES_ENTITY);
            record.setId(UUID.randomUUID());
            record.setUserId(favoriteDish.getUserId());
            record.setTimesEaten(favoriteDish.getTimesEaten());
            record.setAverageWeight(favoriteDish.getAverageWeight());

            dsl.batchInsert(record).execute();

            ids.add(record.getId());

        }

        return ids;

    }

    @Override
    public Optional<FavoriteDishEntity> findById(UUID id) {
        return Optional.of(Objects.requireNonNull(dsl.fetchOne(FAVORITE_DISHES_ENTITY, FAVORITE_DISHES_ENTITY.ID.eq(id)))
                .into(FavoriteDishEntity.class));
    }

    @Override
    public List<FavoriteDishEntity> findAll() {
        return new ArrayList<>(dsl.select().from(FAVORITE_DISHES_ENTITY).fetch().into(FavoriteDishEntity.class));
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(FAVORITE_DISHES_ENTITY).where(FAVORITE_DISHES_ENTITY.ID.eq(id)).execute();
    }

    @Override
    public void putById(UUID id, FavoriteDishEntity favoriteDish) {
        UsersRecord record = new UsersRecord();
        record.from(favoriteDish);
        dsl.update(FAVORITE_DISHES_ENTITY).set(record).where(FAVORITE_DISHES_ENTITY.ID.eq(id)).execute();
    }
}
