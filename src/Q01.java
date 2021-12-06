import java.util.Scanner;

public class Q01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.close();

        int candies = m * n;
        int wrappers = candies;
        int totalCandies = candies;
        while (wrappers >= p) {
            candies = wrappers / p * q;
            totalCandies += candies;
            wrappers %= p;
            wrappers += candies;
        }
        System.out.println(totalCandies);
    }
}
