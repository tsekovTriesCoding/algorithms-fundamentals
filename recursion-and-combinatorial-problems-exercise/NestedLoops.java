import java.util.Scanner;

public class NestedLoops {
    public static int[] arr;
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        arr = new int[n];

        nestedLoops(0);
    }

    private static void nestedLoops(int index) {
        if (index == arr.length) {
            printArr();
        } else {
            for (int i = 1; i <= n; i++) {
                arr[index] = i;
                nestedLoops(index + 1);
            }
        }
    }

    private static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
