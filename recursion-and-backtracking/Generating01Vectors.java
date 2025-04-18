import java.util.Scanner;

public class Generating01Vectors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Integer[] vector = new Integer[n];

        generateVector(vector, 0);
    }

    private static void generateVector(Integer[] vector, int index) {
        if (index >= vector.length) {
            print(vector);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            generateVector(vector, index + 1);
        }
    }

    private static void print(Integer[] vector) {
        for (Integer integer : vector) {
            System.out.print(integer);
        }

        System.out.println();
    }
}
