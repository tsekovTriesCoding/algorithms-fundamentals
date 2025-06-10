import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Guards {
    static int[][] graph;
    static Set<Integer> notVisited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        graph = new int[nodes + 1][nodes + 1];
        notVisited = new HashSet<>();

        for (int i = 0; i < nodes; i++) {
            notVisited.add(i + 1);
        }

        for (int i = 0; i < edges; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);

            graph[from][to] = 1;
        }

        int startNode = Integer.parseInt(scanner.nextLine());

        dfs(graph, startNode);

        notVisited.stream()
                .sorted()
                .forEach(n -> System.out.print(n + " "));
    }

    private static void dfs(int[][] graph, int currentNode) {
        if (!notVisited.contains(currentNode)) {
            return;
        }

        notVisited.remove(currentNode);

        for (int i = 1; i < graph.length; i++) {
            if (graph[currentNode][i] == 1) {
                dfs(graph, i);
            }
        }
    }
}
