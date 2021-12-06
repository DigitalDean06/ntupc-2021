import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author ongzz
 */
public class Q10 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Double> prices = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      double price = scanner.nextDouble();
      prices.add(price);
    }
    scanner.close();

    double sum = 0.0;
    Collections.sort(prices);

    for (int a = 0; a < 2; a++) {
      List<Double> lowestCombination = new ArrayList<>();
      double lowestSum = Double.MAX_VALUE;

      for (int i = 0; i < prices.size() - 2; i++) {
        for (int j = i + 1; j < prices.size() - 1; j++) {
          for (int k = j + 1; k < prices.size(); k++) {
            double tempSum = prices.get(i) + prices.get(j) + prices.get(k);
            if (tempSum >= 80) {
              if (lowestSum > tempSum) {
                lowestSum = tempSum;
                lowestCombination.clear();
                lowestCombination.add(prices.get(i));
                lowestCombination.add(prices.get(j));
                lowestCombination.add(prices.get(k));
              }
            }
          }
        }
      }

      if (!lowestCombination.isEmpty()) {
        sum += lowestSum;
        prices.removeAll(lowestCombination);
        sum += prices.get(prices.size() - 1) / 2.0;
        prices.remove(prices.size() - 1);
      }
    }

    System.out.printf("%.2f%n", sum);
  }
}
