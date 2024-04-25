package ru.itis.agona.repository.user;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.SortOrder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.EatenFoodEntity;
import ru.itis.agona.model.UserEntity;
import ru.itis.agona.model.jooq.schema.tables.records.UsersRecord;

import java.util.*;

import static ru.itis.agona.model.jooq.schema.Tables.EATEN_FOODS_ENTITY;
import static ru.itis.agona.model.jooq.schema.Tables.USERS_ENTITY;

@Repository
@Primary
@RequiredArgsConstructor
public class UserJooqRepository implements UserRepository {

    private final DSLContext dsl;


    @Override
    public Set<UUID> save(List<UserEntity> userEntities) {

        Set<UUID> ids = new HashSet<>();

        for (UserEntity user : userEntities) {

            UsersRecord record = dsl.newRecord(USERS_ENTITY);
            record.setId(UUID.randomUUID());
            record.setName(user.getName());
            record.setSurname(user.getSurname());
            record.setAge(user.getAge());
            record.setWeight(user.getWeight());
            record.setHeight(user.getHeight());
            record.setTypeOfFood(user.getTypeOfFood());

            dsl.batchInsert(record).execute();

            ids.add(record.getId());

        }

        return ids;

    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return Optional.of(Objects.requireNonNull(dsl.fetchOne(USERS_ENTITY, USERS_ENTITY.ID.eq(id)))
                .into(UserEntity.class));
    }

    @Override
    public List<UserEntity> findAll() {
        return new ArrayList<>(dsl.select().from(USERS_ENTITY).fetch().into(UserEntity.class));
    }

    @Override
    public List<EatenFoodEntity> findEatenFoodsById(UUID id) {
        return new ArrayList<>(dsl.select().from(EATEN_FOODS_ENTITY).
                where(EATEN_FOODS_ENTITY.USER_ID.eq(id)).fetch().into(EatenFoodEntity.class));
    }

    @Override
    public List<UserEntity> getAll(int pageNumber, int pageSize, String direction, String name) {
        if (direction.equals("asc") || direction.equals("ASC")) {
            return new ArrayList<>( dsl.select().from(USERS_ENTITY).
                    orderBy(USERS_ENTITY.field(name).sortAsc()).limit(pageSize).offset(pageNumber * pageSize).fetch().into(UserEntity.class));
        } else {
        return new ArrayList<>(dsl.select().from(USERS_ENTITY).
                orderBy(USERS_ENTITY.field(name).sortDesc()).limit(pageSize).offset(pageNumber * pageSize).fetch().into(UserEntity.class));
        }
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(USERS_ENTITY).where(USERS_ENTITY.ID.eq(id)).execute();
    }

    @Override
    public void putById(UUID id, UserEntity user) {
        UsersRecord record = new UsersRecord();
        record.from(user);
        dsl.update(USERS_ENTITY).set(record).where(USERS_ENTITY.ID.eq(id)).execute();
    }

}
