package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Exercise7_24 {
  
  public static void main(String[] args) {
    List<String> list1 = List.of("Peter", "Sonia", "Paul");
    List<String> list2 = Arrays.asList("Fenia", "Kate", "Dennis");
    
    List<String> list3 = new ArrayList<>(list1);
    list3.addLast("Hector");
    System.out.println(list3);
    List<String> list4 = list2.stream().collect(Collectors.toList());
    list4.addFirst("Hana");
    System.out.println(list4);
    
    Item drinkItem = new DrinkItem("Milk", 1.89);
    Item foodItem = new FoodItem("Yogurt", 4.59);
    if (drinkItem instanceof DrinkItem item) {
      var name = item.name();
      var price = item.price();
      System.out.printf("Name: %s, Price: %.2f\n", name, price);
    }
    if (foodItem instanceof FoodItem(String name, double price)) {
      System.out.printf("Name: %s, Price: %.2f\n", name, price);
    }
    
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  interface Item { };
  public record FoodItem(String name, double price) implements Item { };
  public record DrinkItem(String name, double price) implements Item { };
  
}
