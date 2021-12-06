import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q02 {

    public static void main(String[] args) {
        Map<String, Double> speciesGrowthFactorMap = new HashMap<>();
        speciesGrowthFactorMap.put("American Beech", 6.0);
        speciesGrowthFactorMap.put("Basswood", 3.0);
        speciesGrowthFactorMap.put("Common Horsechestnut", 8.0);
        speciesGrowthFactorMap.put("Dogwood", 7.0);
        speciesGrowthFactorMap.put("European White Birch", 5.0);
        speciesGrowthFactorMap.put("White Fir", 7.5);
        Scanner scanner = new Scanner(System.in);
        int numberOfTrees;
        if (scanner.hasNextInt()) {
            numberOfTrees = scanner.nextInt();
            if (numberOfTrees <= 0) {
                System.out.println("You must specify a positive integer number for the number of trees!");
                return;
            }
        } else {
            System.out.println("You must specify a positive integer number for the number of trees!");
            return;
        }
        for (int i = 0; i < numberOfTrees; i++) {
            double circumference = scanner.nextDouble();
            scanner.nextLine();
            String treeSpecies = scanner.nextLine();
            if (circumference <= 0.0) {
                System.out.println("The circumference for " + treeSpecies + " must be greater than 0!");
                continue;
            }
            if (speciesGrowthFactorMap.containsKey(treeSpecies)) {
                System.out.println(treeSpecies + " : " + circumference + " : " + Math.round(circumference / 3.141592 * speciesGrowthFactorMap.get(treeSpecies) * 10.0) / 10.0);
            } else {
                System.out.println("Species entered is not available!");
            }
        }
        scanner.close();
    }
}
