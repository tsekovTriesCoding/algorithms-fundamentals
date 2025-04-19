import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long factorial = getFactorial(n);

        System.out.println(factorial);
    }

    private static long getFactorial(int n) {
        if (n == 1) return 1;

        return n * getFactorial(n - 1);
    }
}
