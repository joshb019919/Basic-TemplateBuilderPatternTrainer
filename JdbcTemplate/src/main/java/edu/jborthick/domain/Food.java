package edu.jborthick.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@Getter
@ToString
public class Food {
  private int food_id;
  private String food_name;
  private Date acquired_date;
}
