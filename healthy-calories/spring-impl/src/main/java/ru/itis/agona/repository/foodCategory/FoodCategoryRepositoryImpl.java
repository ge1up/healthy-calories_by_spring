package ru.itis.agona.repository.foodCategory;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FoodCategoryEntity;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FoodCategoryRepositoryImpl implements FoodCategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    private final static String SQL_CREATE = "insert into food_categories values (?, ?)";

    private final static String SQL_GET_BY_ID = "select * from food_categories where id = ?";

    private final static String SQL_GET_ALL = "select * from food_categories";

    private final static String SQL_DELETE_BY_ID = "delete from food_categories where id = ?";

    private final static String SQL_PUT_BY_ID = "update food_categories set name = ? where id = ?";

    private RowMapper<FoodCategoryEntity> mapper = (rs, rowNum) -> FoodCategoryEntity.builder()
            .id( (UUID) rs.getObject("id"))
            .name(rs.getString("name"))
            .build();


    @Override
    public Set<UUID> save(List<FoodCategoryEntity> foodCategoryEntities) {
        Set<UUID> ids = new HashSet<>();
        for (FoodCategoryEntity foodCategory : foodCategoryEntities) {
            UUID id = UUID.randomUUID();
            jdbcTemplate.update(SQL_CREATE, id, foodCategory.getName());
            ids.add(id);
        }
        return ids;
    }

    @Override
    public Optional<FoodCategoryEntity> findById(UUID id) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_BY_ID, mapper, id)) {
            return stream.findAny();
        }
    }

    @Override
    public List<FoodCategoryEntity> findAll() {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_ALL, mapper)) {
            return stream.collect(Collectors.toList());
        }
    }

    @Override
    public void deleteById(UUID id) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, id);
    }

    @Override
    public void putById(UUID id, FoodCategoryEntity foodCategory) {
        jdbcTemplate.update(SQL_PUT_BY_ID, foodCategory.getName(), id);
    }
}
