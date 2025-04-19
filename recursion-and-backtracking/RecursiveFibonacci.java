import java.util.Arrays;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int fibonacci = fibonacci(n, memo);

        System.out.println(fibonacci);
    }

    private static int fibonacci(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        // Recursive case: calculate Fibonacci number
        // and store it in memo
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);

        return memo[n];
    }
}
