import java.util.Scanner;

public class CombinationsWithoutRepetition {
    public static String[] elements;
    public static String[] combinations;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        combinations = new String[k];
        used = new boolean[elements.length];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == combinations.length) {
            print(combinations);
        } else {
            for (int i = start; i < elements.length; i++) {
                combinations[index] = elements[i];
                combinations(index + 1, i + 1);
            }
        }
    }

    private static void print(String[] variations) {
        System.out.println(String.join(" ", variations));
    }
}
