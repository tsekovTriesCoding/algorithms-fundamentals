import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int num = scanner.nextInt();

        Arrays.sort(array);

        System.out.println(indexOf(array, num));
    }

    private static int indexOf(int[] array, int num) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int curr = array[mid];

            if (num < curr) {
                end = mid - 1;
            } else if (num > curr) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
