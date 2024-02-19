package edu.jborthick.service;

import edu.jborthick.dao.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodReportService {
  @Autowired
  private FoodDao foodDao;

  public void printReport() {
    System.out.println("Food Report Start!");

    System.out.println("Food count: " + foodDao.findFoodCount());
    System.out.println("Earliest acquired food: " + foodDao.findFirstAcquiredFood());
    System.out.println("List of all foods: ");
    foodDao.findFoods().forEach(System.out::println);

    System.out.println("Food Report Stop...");
  }
}
