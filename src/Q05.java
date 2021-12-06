import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q05 {

  public static void main(String[] args) {
    List<Character> route = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < n; i++) {
      String input = scanner.nextLine();
      char from = input.charAt(0);
      char to = input.charAt(1);
      int fromIndex = route.indexOf(from);
      int toIndex = route.indexOf(to);
      if (fromIndex > toIndex) {
        int buff = fromIndex;
        fromIndex = toIndex;
        toIndex = buff;
      }
      while (fromIndex < toIndex) {
        char buff = route.get(fromIndex);
        route.set(fromIndex, route.get(toIndex));
        route.set(toIndex, buff);
        fromIndex++;
        toIndex--;
      }
    }
    scanner.close();

    for (char c : route) {
      System.out.print(c);
    }
    System.out.println("a");
  }
}
