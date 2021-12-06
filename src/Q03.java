import java.util.*;

public class Q03 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String paragraph = scanner.nextLine();
    scanner.close();

    String[] words = paragraph.toUpperCase()
            .replaceAll("\\.", "")
            .replaceAll(",", "")
            .replaceAll("\\?", "")
            .replaceAll("!", "")
            .replaceAll("\"", "")
            .split(" ");
    Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
    System.out.println(uniqueWords.size());
    List<String> sortedUniqueWords = new ArrayList<>(uniqueWords);
    Collections.sort(sortedUniqueWords);
    sortedUniqueWords.forEach(System.out::println);
  }
}
