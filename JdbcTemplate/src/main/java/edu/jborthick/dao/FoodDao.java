package edu.jborthick.dao;

import edu.jborthick.domain.Food;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class FoodDao {
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public List<Food> findFoods() {
    return jdbcTemplate.query(
        "SELECT * FROM foods",
        this::mapFood
    );
  }

  public Food findFirstAcquiredFood() {
    return jdbcTemplate.queryForObject(
        "SELECT * FROM foods ORDER BY acquired_date LIMIT 1",
        this::mapFood
    );
  }

  public int findFoodCount() {
    return jdbcTemplate.queryForObject(
        "SELECT COUNT(*) FROM foods",
        Integer.class
    );
  }

  @SneakyThrows
  private Food mapFood(ResultSet resultSet, int i) {
    return new Food(
        resultSet.getInt("food_id"),
        resultSet.getString("food_name"),
        resultSet.getDate("acquired_date")
    );
  }

}
