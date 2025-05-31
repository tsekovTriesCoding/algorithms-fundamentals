import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];

        Arrays.fill(prev, -1);

        int maxLength = 0;
        int maxIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            int max = 1;
            int bestIndex = -1;

            for (int j = i; j >= 0; j--) {
                if (sequence[j] < current && length[j] + 1 >= max) {
                    max = length[j] + 1;
                    bestIndex = j;
                }
            }

            prev[i] = bestIndex;
            length[i] = max;

            if (maxLength < max) {
                maxLength = max;
                maxIndex = i;
            }
        }

        Deque<Integer> result = new ArrayDeque<>();

        while (maxIndex != -1) {
            result.push(sequence[maxIndex]);
            maxIndex = prev[maxIndex];
        }


        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
