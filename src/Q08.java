import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q08 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    List<String> inputs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      inputs.add(scanner.nextLine());
    }
    scanner.close();

    for (int i = 0; i < inputs.size(); i++) {
      String input = inputs.get(i);
      if (!input.equals("#")) continue;
      double previous = 0.0;
      double next = 0.0;
      int previousGapCount = 0;
      int nextGapCount = 0;
      for (int j = i - 1; j >= 0; j--) {
        String anotherInput = inputs.get(j);
        if (anotherInput.equals("#")) {
          previousGapCount++;
          continue;
        }
        previous = Double.parseDouble(anotherInput);
        break;
      }
      for (int j = i + 1; j < inputs.size(); j++) {
        String anotherInput = inputs.get(j);
        if (anotherInput.equals("#")) {
          nextGapCount++;
          continue;
        }
        next = Double.parseDouble(anotherInput);
        break;
      }
      double gap = (next - previous) / (previousGapCount + nextGapCount + 1 + 1);
      double data = Math.round((previous + gap * (previousGapCount + 1)) * 100.0) / 100.0;
      System.out.println(data + "0".repeat(2 - String.valueOf(data).split("\\.")[1].length()));
    }
  }
}
