import java.util.Scanner;

public class Q07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int numberOfMines = scanner.nextInt();
        char[][] map = new char[columns][rows];
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                map[x][y] = '0';
            }
        }
        for (int i = 0; i < numberOfMines; i++) {
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            map[x][y] = '*';
            for (int k = -1; k <= 1; k++) {
                for (int l = -1; l <= 1; l++) {
                    if (k == 0 && l == 0) continue;
                    if (x + k < 0 || x + k >= columns || y + l < 0 || y + l >= rows) continue;
                    if (map[x + k][y + l] == '*') continue;
                    map[x + k][y + l] = String.valueOf(Integer.parseInt(String.valueOf(map[x + k][y + l])) + 1).charAt(0);
                }
            }
        }
        scanner.close();

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                System.out.print(map[x][y]);
            }
            System.out.println();
        }
    }
}
