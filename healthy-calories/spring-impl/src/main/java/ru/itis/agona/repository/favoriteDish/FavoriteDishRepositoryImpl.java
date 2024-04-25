package ru.itis.agona.repository.favoriteDish;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FavoriteDishEntity;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FavoriteDishRepositoryImpl implements FavoriteDishRepository {

    private final JdbcTemplate jdbcTemplate;

    private final static String SQL_CREATE = "insert into favorite_dishes values (?, ?, ?, ?)";

    private final static String SQL_GET_BY_ID = "select * from favorite_dishes where id = ?";

    private final static String SQL_GET_ALL = "select * from favorite_dishes";

    private final static String SQL_DELETE_BY_ID = "delete from favorite_dishes where id = ?";

    private final static String SQL_PUT_BY_ID = new StringBuilder("update favorite_dishes set ")
            .append("user_id = ?, times_eaten = ?, average_weight = ? where id = ?").toString();

    private RowMapper<FavoriteDishEntity> mapper = (rs, rowNum) -> FavoriteDishEntity.builder()
            .id( (UUID) rs.getObject("id"))
            .timesEaten(rs.getShort("times_eaten"))
            .averageWeight(rs.getShort("average_weight"))
            .build();


    @Override
    public Set<UUID> save(List<FavoriteDishEntity> favoriteDishEntities) {
        Set<UUID> ids = new HashSet<>();
        for (FavoriteDishEntity favoriteDish : favoriteDishEntities) {
            UUID id = UUID.randomUUID();
            jdbcTemplate.update(SQL_CREATE, id, favoriteDish.getUserId(),
                    favoriteDish.getTimesEaten(), favoriteDish.getAverageWeight());
            ids.add(id);
        }
        return ids;
    }

    @Override
    public Optional<FavoriteDishEntity> findById(UUID id) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_BY_ID, mapper, id)) {
            return stream.findAny();
        }
    }

    @Override
    public List<FavoriteDishEntity> findAll() {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_ALL, mapper)) {
            return stream.collect(Collectors.toList());
        }
    }

    @Override
    public void deleteById(UUID id) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, id);
    }

    @Override
    public void putById(UUID id, FavoriteDishEntity favoriteDish) {
        jdbcTemplate.update(SQL_PUT_BY_ID, favoriteDish.getUserId(),
                favoriteDish.getTimesEaten(), favoriteDish.getAverageWeight(), id);
    }
}
