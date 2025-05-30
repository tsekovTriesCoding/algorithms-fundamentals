import java.util.Scanner;

public class Fibonacci {
    private static long[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        dp = new long[n + 1];

        long fib = calcFib(n);

        System.out.println(fib);
    }

    private static long calcFib(int n) {
        if (n <= 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = calcFib(n - 1) + calcFib(n - 2);
    }
}
