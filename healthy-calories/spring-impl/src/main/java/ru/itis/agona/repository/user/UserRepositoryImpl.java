package ru.itis.agona.repository.user;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jooq.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.EatenFoodEntity;
import ru.itis.agona.model.UserEntity;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final static String SQL_CREATE = "insert into users values (?, ?, ?, ?, ?, ?, ?)";

    private final static String SQL_GET_BY_ID = "select * from users where id = ?";

    private final static String SQL_GET_ALL = "select * from users";

    private final static String SQL_GET_PAGE = "select * from users order by %s %s limit %s offset %s";

    private final static String SQL_DELETE_BY_ID = "delete from users where id = ?";

    private final static String SQL_GET_EATEN_FOODS_BY_ID = "select * from eaten_foods where user_id = ?";

    private final static String SQL_PUT_BY_ID =
            "update users set name = ?, surname = ?, age = ?, weight = ?, height = ?, type_of_food = ? where id = ?";

    private RowMapper<UserEntity> userMapper = (rs, rowNum) -> UserEntity.builder()
            .id( (UUID) rs.getObject("id"))
            .name(rs.getString("name"))
            .surname(rs.getString("surname"))
            .age(rs.getShort("age"))
            .weight(rs.getShort("weight"))
            .height(rs.getShort("height"))
            .typeOfFood(rs.getShort("type_of_food"))
            .build();

    private RowMapper<EatenFoodEntity> eatenFoodMapper = (rs, rowNum) -> EatenFoodEntity.builder()
            .id( (UUID) rs.getObject("id"))
            .weight(rs.getShort("weight"))
            .userId( (UUID) rs.getObject("user_id"))
            .foodId( (UUID) rs.getObject("food_id"))
            .createdDate( (Instant) rs.getObject("created_date"))
            .build();

    public Set<UUID> save(List<UserEntity> userEntities) {
        Set<UUID> ids = new HashSet<>();
        for (int i = 0; i < userEntities.size(); i++) {
            UUID id = UUID.randomUUID();
            UserEntity user = userEntities.get(i);
            jdbcTemplate.update(SQL_CREATE, id, user.getName(), user.getSurname(),
                    user.getAge(), user.getWeight(), user.getHeight(), user.getTypeOfFood());
            ids.add(id);
        }
        return ids;
    }

    public Optional<UserEntity> findById(UUID id) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_BY_ID, userMapper, id)){
            return stream.findAny();
        }
    }

    @Override
    public List<UserEntity> findAll() {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_ALL, userMapper)) {
            return stream.collect(Collectors.toList());
        }
    }

    @Override
    public List<EatenFoodEntity> findEatenFoodsById(UUID id) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_EATEN_FOODS_BY_ID, eatenFoodMapper, id)) {
            return stream.collect(Collectors.toList());
        }
    }

    @Override
    public List<UserEntity> getAll(int pageNumber, int pageSize, String direction, String name) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_PAGE.formatted(name, direction, pageSize, pageNumber * pageSize), userMapper)) {
            return stream.collect(Collectors.toList());
        }
    }

    @Override
    public void deleteById(UUID id) {
            jdbcTemplate.update(SQL_DELETE_BY_ID, id);
    }

    @Override
    public void putById(UUID id, UserEntity user) {
        jdbcTemplate.update(SQL_PUT_BY_ID, user.getName(), user.getSurname(), user.getAge(),
                user.getWeight(), user.getHeight(), user.getTypeOfFood(), id);
    }


}
