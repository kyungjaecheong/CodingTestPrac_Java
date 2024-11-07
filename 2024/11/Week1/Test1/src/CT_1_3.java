public class CT_1_3 {

    public int solution(int N) {
        if (N == 1) return 1;
        if (N == 2) return 2;

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

    public static void main(String[] args) {
        CT_1_3 t = new CT_1_3();
        System.out.println(t.solution(4)); // 5
    }
}
