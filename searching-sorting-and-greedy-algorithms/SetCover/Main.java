package SetCover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }
        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }
        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("\\[|]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> chosenSets = new ArrayList<>();
        Set<Integer> remainingElements = new HashSet<>();
        
        // Initialize remaining elements from universe
        for (int element : universe) {
            remainingElements.add(element);
        }

        while (!remainingElements.isEmpty() && !sets.isEmpty()) {
            int[] bestSet = null;
            int maxCovered = 0;

            // Find the set that covers the most remaining elements
            for (int[] set : sets) {
                int coverCount = 0;
                for (int element : set) {
                    if (remainingElements.contains(element)) {
                        coverCount++;
                    }
                }
                if (coverCount > maxCovered) {
                    maxCovered = coverCount;
                    bestSet = set;
                }
            }

            // If we found a set that covers some remaining elements
            if (bestSet != null) {
                chosenSets.add(bestSet);
                // Remove covered elements from remaining elements
                for (int element : bestSet) {
                    remainingElements.remove(element);
                }
                sets.remove(bestSet);
            } else {
                break;
            }
        }

        return chosenSets;
    }
}