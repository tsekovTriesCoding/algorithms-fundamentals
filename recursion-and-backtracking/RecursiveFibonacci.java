import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecursiveFibonacci {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long fibonacci = fibonacci(n);

        System.out.println(fibonacci);
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long result = fibonacci(n - 1) + fibonacci(n - 2);

        memo.put(n, result);

        return result;
    }
}
