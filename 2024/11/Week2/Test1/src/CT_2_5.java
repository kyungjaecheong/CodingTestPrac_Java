import java.util.Arrays;

public class CT_2_5 {

    public int[][] solution(int[][] image, int K) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[rows][cols];
        int padding = K / 2;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int count = 0;

                for (int ki = -padding; ki <= padding; ki++) {
                    for (int kj = -padding; kj <= padding; kj++) {
                        int ni = i + ki;
                        int nj = j + kj;

                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                            sum += image[ni][nj];
                        }
                        count++;
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] image = {
                {4, 5, 2, 6, 7},
                {5, 4, 2, 4, 6},
                {6, 8, 4, 8, 7},
                {7, 3, 6, 6, 4},
                {5, 0, 4, 1, 5}
        };
        int K = 3;

        CT_2_5 t = new CT_2_5();

        int[][] averagedImage = t.solution(image, K);

        // Print the result
        for (int[] row : averagedImage) {
            System.out.println(Arrays.toString(row));
        }
    }
}
