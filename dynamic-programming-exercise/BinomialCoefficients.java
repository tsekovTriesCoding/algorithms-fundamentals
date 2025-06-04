import java.util.Scanner;

public class BinomialCoefficients {
    public static long[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        memo = new long[n + 1][k + 1];

        long binom = calcBinom(n, k);

        System.out.println(binom);
    }

    private static long calcBinom(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        if (memo[n][k] != 0) {
            return memo[n][k];
        }

        return memo[n][k] = calcBinom(n - 1, k - 1) + calcBinom(n - 1, k);
    }
}
