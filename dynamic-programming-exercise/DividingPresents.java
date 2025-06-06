import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class DividingPresents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] presents = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int totalSum = Arrays.stream(presents).sum();
        
        // Create dp array where each cell contains the sum we can achieve
        boolean[] possible = new boolean[totalSum + 1];
        int[] prevSum = new int[totalSum + 1];
        int[] prevIndex = new int[totalSum + 1];
        
        possible[0] = true;
        
        // For each present
        for (int i = 0; i < presents.length; i++) {
            // Check all possible sums from largest to smallest
            for (int sum = totalSum; sum >= presents[i]; sum--) {
                if (possible[sum - presents[i]] && !possible[sum]) {
                    possible[sum] = true;
                    prevSum[sum] = sum - presents[i];
                    prevIndex[sum] = i;
                }
            }
        }
        
        // Find the best sum for Alan (closest to totalSum/2)
        int alanSum = totalSum / 2;
        while (!possible[alanSum]) {
            alanSum--;
        }
        
        int bobSum = totalSum - alanSum;

        System.out.println("Difference: " + (bobSum - alanSum));
        System.out.println("Alan:" + alanSum + " Bob:" + bobSum);

        ArrayList<Integer> alanPresents = new ArrayList<>();
        int currentSum = alanSum;
        
        while (currentSum > 0) {
            alanPresents.add(presents[prevIndex[currentSum]]);
            currentSum = prevSum[currentSum];
        }
        
        System.out.print("Alan takes: ");
        for (Integer present : alanPresents) {
            System.out.print(present + " ");
        }
        System.out.println("\nBob takes the rest.");
    }
}