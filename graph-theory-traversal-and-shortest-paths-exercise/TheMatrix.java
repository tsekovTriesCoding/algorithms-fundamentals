import java.util.Scanner;

public class TheMatrix {
    private static String[][] matrix;
    private static String fillChar;
    private static String toBeReplaced;
    private static int startRow;
    private static int startCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            System.arraycopy(tokens, 0, matrix[i], 0, cols);
        }

        fillChar = scanner.nextLine();

        dimensions = scanner.nextLine().split("\\s+");
        startRow = Integer.parseInt(dimensions[0]);
        startCol = Integer.parseInt(dimensions[1]);
        toBeReplaced = matrix[startRow][startCol];

        solve();
        String result = toOutputString();

        System.out.println(result);
    }

    public static void solve() {
        fillMatrix(startRow, startCol);
    }

    private static void fillMatrix(int row, int col) {
        if (isOutOfBounds(row, col) || !matrix[row][col].equals(toBeReplaced)) {
            return;
        }

        matrix[row][col] = fillChar;

        fillMatrix(row + 1, col);
        fillMatrix(row, col + 1);
        fillMatrix(row - 1, col);
        fillMatrix(row, col - 1);
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    public static String toOutputString() {
        StringBuilder builder = new StringBuilder();
        for (String[] strings : matrix) {
            for (String string : strings) {
                builder.append(string);
            }
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
