import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String criminal = scanner.nextLine();
        String suspect1 = scanner.nextLine();
        String suspect2 = scanner.nextLine();
        String suspect3 = scanner.nextLine();
        String suspect4 = scanner.nextLine();
        scanner.close();

        int index = Arrays.asList(suspect1, suspect2, suspect3, suspect4).indexOf(criminal);
        System.out.println(index + 1);
        System.out.println(index == -1 ? 0 : getLongestCombinations(criminal, str));
    }

    private static int getLongestCombinations(String suspect, String str) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < suspect.length() - (str.length() - 1); i++) {
            if (suspect.startsWith(str, i)) integerList.add(i);
        }
        int longestCombination = 0;
        int combination = 1;
        for (int i = 0; i < integerList.size() - 1; i++) {
            if (integerList.get(i + 1) - integerList.get(i) > str.length()) {
                if (combination > longestCombination) longestCombination = combination;
                combination = 1;
            } else {
                combination++;
            }
        }
        if (combination > longestCombination) longestCombination = combination;
        return longestCombination;
    }
}
