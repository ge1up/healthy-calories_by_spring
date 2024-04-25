package ru.itis.agona.repository.food;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FoodEntity;
import ru.itis.agona.model.UserEntity;
import ru.itis.agona.repository.food.FoodRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Primary
@RequiredArgsConstructor
public class FoodRepositoryImpl implements FoodRepository {

    private final JdbcTemplate jdbcTemplate;

    private final static String SQL_CREATE = "insert into foods values (?, ?, ?, ?, ?, ?, ?, ?)";

    private final static String SQL_GET_BY_ID = "select * from foods where id = ?";

    private final static String SQL_GET_ALL = "select * from foods";

    private final static String SQL_DELETE_BY_ID = "delete from foods where id = ?";

    private final static String SQL_PUT_BY_ID = new StringBuilder("update foods set name = ?, ")
            .append("proteins = ?, fats = ?, carbohydrates = ?, calories_number = ?, ")
            .append("type_of_food = ?, category_id = ? where id = ?").toString();

    private RowMapper<FoodEntity> mapper = (rs, rowNum) -> FoodEntity.builder()
            .id( (UUID) rs.getObject("id"))
            .name(rs.getString("name"))
            .proteins(rs.getShort("proteins"))
            .fats(rs.getShort("fats"))
            .carbohydrates(rs.getShort("carbohydrates"))
            .caloriesNumber(rs.getShort("calories_number"))
            .typeOfFood(rs.getShort("type_of_food"))
            .categoryId( (UUID) rs.getObject("category_id"))
            .build();


    @Override
    public Set<UUID> save(List<FoodEntity> foodEntities) {
        Set<UUID> ids = new HashSet<>();
        for (FoodEntity food : foodEntities) {
            UUID id = UUID.randomUUID();
            jdbcTemplate.update(SQL_CREATE, id, food.getName(), food.getProteins(), food.getFats(),
                    food.getCarbohydrates(), food.getCaloriesNumber(), food.getTypeOfFood(), food.getCategoryId());
            ids.add(id);
        }
        return ids;
    }

    @Override
    public Optional<FoodEntity> findById(UUID id) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_BY_ID, mapper, id)) {
            return stream.findAny();
        }
    }

    @Override
    public List<FoodEntity> findAll() {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_ALL, mapper)) {
            return stream.collect(Collectors.toList());
        }
    }

    @Override
    public void deleteById(UUID id) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, id);
    }

    @Override
    public void putById(UUID id, FoodEntity food) {
        jdbcTemplate.update(SQL_PUT_BY_ID, food.getName(), food.getProteins(), food.getFats(),
                food.getCarbohydrates(), food.getCaloriesNumber(), food.getTypeOfFood(), food.getCategoryId(), id);
    }
}
