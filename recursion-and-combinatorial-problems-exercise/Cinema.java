import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cinema {
    public static List<String> people;
    public static String[] seats;
    public static String[] permutations;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        people = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        seats = new String[people.size()];

        String command = scanner.nextLine();

        while (!command.equals("generate")) {
            String[] tokens = command.split(" - ");
            String name = tokens[0];
            int place = Integer.parseInt(tokens[1]) - 1;

            seats[place] = name;
            people.remove(name);

            command = scanner.nextLine();
        }

        permutations = new String[people.size()];
        used = new boolean[people.size()];

        permute(0);
    }

    private static void permute(int index) {
        if (index == permutations.length) {
            print();
        } else {
            for (int i = 0; i < people.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    permutations[index] = people.get(i);
                    permute(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        int index = 0;
        String[] out = new String[seats.length];

        for (int i = 0; i < out.length; i++) {
            if (seats[i] != null) {
                out[i] = seats[i];
            } else {
                out[i] = permutations[index++];
            }
        }

        System.out.println(String.join(" ", out));
    }
}
