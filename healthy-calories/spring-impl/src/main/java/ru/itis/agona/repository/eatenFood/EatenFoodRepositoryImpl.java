package ru.itis.agona.repository.eatenFood;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.EatenFoodEntity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EatenFoodRepositoryImpl implements EatenFoodRepository {

    private final JdbcTemplate jdbcTemplate;

    private final static String SQL_CREATE = "insert into eaten_foods values (?, ?, ?, ?, ?)";

    private final static String SQL_GET_BY_ID = "select * from eaten_foods where id = ?";

    private final static String SQL_GET_ALL = "select * from eaten_foods";

    private final static String SQL_DELETE_BY_ID = "delete from eaten_foods where id = ?";

    private final static String SQL_PUT_BY_ID = new StringBuilder("update eaten_foods set user_id = ?, ")
            .append("food_id = ?, weight = ?, created_date = ? where id = ?").toString();

    private RowMapper<EatenFoodEntity> mapper = (rs, rowNum) -> EatenFoodEntity.builder()
            .id( (UUID) rs.getObject("id"))
            .userId( (UUID) rs.getObject("user_id"))
            .foodId( (UUID) rs.getObject("food_id"))
            .weight(rs.getShort("weight"))
            .createdDate( (Instant) rs.getObject("created_date"))
            .build();

    @Override
    public Set<UUID> save(List<EatenFoodEntity> eatenFoodEntities) {
        Set<UUID> ids = new HashSet<>();
        for (EatenFoodEntity eatenFood : eatenFoodEntities) {
            UUID id = UUID.randomUUID();
            jdbcTemplate.update(SQL_CREATE, id, eatenFood.getUserId(),
                    eatenFood.getFoodId(), eatenFood.getWeight(), eatenFood.getCreatedDate());
            ids.add(id);
        }
        return ids;
    }

    @Override
    public Optional<EatenFoodEntity> findById(UUID id) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_BY_ID, mapper, id)) {
            return stream.findAny();
        }
    }

    @Override
    public List<EatenFoodEntity> findAll() {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_ALL, mapper)) {
            return stream.collect(Collectors.toList());
        }
    }

    @Override
    public void deleteById(UUID id) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, id);
    }

    @Override
    public void putById(UUID id, EatenFoodEntity eatenFood) {
        jdbcTemplate.update(SQL_PUT_BY_ID, eatenFood.getUserId(), eatenFood.getFoodId(),
                eatenFood.getWeight(), eatenFood.getCreatedDate(), id);
    }
}
