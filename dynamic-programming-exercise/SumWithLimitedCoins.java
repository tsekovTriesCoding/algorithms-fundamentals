import java.util.Arrays;
import java.util.Scanner;

public class SumWithLimitedCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read all coins (including duplicates)
        int[] coins = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetSum = scanner.nextInt();

        int result = findWays(coins, 0, targetSum, "");
        System.out.println(result);
    }

    private static int findWays(int[] coins, int index, int remaining, String currentCombination) {
        if (remaining == 0) {
            return 1;
        }

        if (remaining < 0 || index >= coins.length) {
            return 0;
        }

        int ways = 0;

        ways += findWays(coins, index + 1, remaining - coins[index], 
                        currentCombination + coins[index] + " ");

        int nextDifferentCoin = index + 1;
        while (nextDifferentCoin < coins.length && coins[nextDifferentCoin] == coins[index]) {
            nextDifferentCoin++;
        }
        ways += findWays(coins, nextDifferentCoin, remaining, currentCombination);

        return ways;
    }
}