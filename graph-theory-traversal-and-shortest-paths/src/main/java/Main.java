import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String nextLine = scanner.nextLine();

            if (nextLine.trim().isBlank()) {
                graph.add(new ArrayList<>());
                continue;
            }

            List<Integer> nextNodes = Arrays.stream(nextLine.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            graph.add(nextNodes);
        }

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

        connectedComponents.forEach(c -> {
            System.out.println("Connected component: " + c.toString()
                    .replaceAll("[\\[\\]]", "")
                    .replaceAll(", ", " "));
        });
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> connectedComponents = new ArrayList<>();

        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
                connectedComponents.add(new ArrayDeque<>());
                bfs(start, connectedComponents, graph, visited);
            }
        }

        return connectedComponents;
    }

    private static void bfs(int start, List<Deque<Integer>> connectedComponents, List<List<Integer>> graph, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            connectedComponents.get(connectedComponents.size() - 1).offer(node);

            for (Integer child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            for (Integer child : graph.get(node)) {
                dfs(child, components, graph, visited);
            }

            components.get(components.size() - 1).offer(node);
        }

    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {
            String nodeToRemove = graph.keySet()
                    .stream()
                    .filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if (nodeToRemove == null) {
                break;
            }

            for (String child : graph.get(nodeToRemove)) {
                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
            }

            sorted.add(nodeToRemove);
            graph.remove(nodeToRemove);
        }

        if (!graph.isEmpty()) {
            throw new IllegalArgumentException("Graph has cycles");
        }

        return sorted;
    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);

            for (String child : node.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) + 1);
            }
        }

        return dependenciesCount;
    }
}
