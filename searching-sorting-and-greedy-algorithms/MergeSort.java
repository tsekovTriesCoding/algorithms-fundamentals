import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(array);

        System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
    }

    private static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int mid = (begin + end) / 2;

        mergeSort(array, begin, mid);
        mergeSort(array, mid + 1, end);

        merge(array, begin, mid, end);
    }

    private static void merge(int[] array, int begin, int mid, int end) {
        if (mid < 0 || mid >= array.length || array[mid] < array[mid + 1]) {
            return;
        }

        int left = begin;
        int right = mid + 1;

        int[] helper = new int[array.length];

        for (int i = begin; i <= end; i++) {
            helper[i] = array[i];
        }

        for (int i = begin; i <= end; i++) {
            if (left > mid) {
                array[i] = helper[right++];
            } else if (right > end) {
                array[i] = helper[left++];
            } else if (helper[left] <= helper[right]) {
                array[i] = helper[left++];
            } else if (helper[left] > helper[right]) {
                array[i] = helper[right++];
            }
        }
    }

}
