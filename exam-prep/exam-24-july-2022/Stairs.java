import java.util.Scanner;

public class Stairs {
    static long[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        memo = new long[n + 1];

        long ways = getWays(n);

        System.out.println(ways);
    }

    private static long getWays(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = getWays(n - 1) + getWays(n - 2);
    }
}
