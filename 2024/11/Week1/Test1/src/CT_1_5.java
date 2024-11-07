public class CT_1_5 {

    public long solution(int N, int M, int K, int[] capacity) {
        long[][] dp = new long[M + 1][N + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                for (int x = 0;
                     x <= capacity[i - 1] && j - x >= 0;
                     x++) {
                    dp[i][j] += dp[i - 1][j - x] * combination(j, x);
                }
            }
        }
        long studentWays = dp[M][N];
        long teacherWays = permutation(K, M);

        return studentWays * teacherWays;
    }

    private long combination(int n, int r) {
        if (r > n || r == 0) return 1;
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    private long permutation(int n, int r) {
        if (r > n) return 1;
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
        }
        return result;
    }

    public static void main(String[] args) {
        CT_1_5 t = new CT_1_5();
        System.out.println(t.solution(10, 3, 4,
                new int[] {3, 3, 4})); //100800
        System.out.println(t.solution(10, 3, 4,
                new int[] {5, 3, 4})); //428400
    }
}
