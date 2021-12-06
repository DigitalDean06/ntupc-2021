import java.util.*;

public class Q09 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String orders = scanner.nextLine();
    scanner.close();

    List<Customer> customers = new ArrayList<>();
    for (String order : orders.split(";")) {
      customers.add(new Customer(order));
    }
    while (customers.stream().anyMatch(customer -> !customer.foods.isEmpty())) {
      Customer.chef = 3;
      customers.forEach(Customer::tick);
    }
    customers.forEach(System.out::println);
  }

  private static class Customer {
    private static int chef = 3;
    private final String name;
    private final Map<String, Integer> foods = new HashMap<>();
    private int hour = 10;
    private int minute = 0;
    private String message;

    public Customer(String order) {
      String[] orderDetails = order.split("#");
      name = orderDetails[0];
      for (String food : orderDetails[1].split("%")) {
        String[] foodDetails = food.split(":");
        foods.put(foodDetails[0], Integer.parseInt(foodDetails[1]));
      }
    }

    public void tick() {
      if ((minute += 5) >= 60) {
        minute = 0;
        hour++;
      }
      int tempChef = chef;
      chef -= Math.min(Math.min(tempChef, foods.keySet().size()), 3);
      List<String> keys = new ArrayList<>(foods.keySet());
      keys.sort((o1, o2) -> foods.get(o2) - foods.get(o1));
      for (int i = 0; i < Math.min(Math.min(tempChef, foods.keySet().size()), 3); i++) {
        String key = keys.get(i);
        foods.replace(key, foods.get(key) - 1);
        if (foods.get(key) <= 0) {
          foods.remove(key);
          if (foods.isEmpty()) {
            message = String.format("%s can collect food at %s:%s", name, hour, minute);
            break;
          }
        }
      }
    }

    @Override
    public String toString() {
      return message;
    }
  }
}
