public class Test2 {

    public static boolean solution(int num) {
        if (num == 1) return false;

        boolean[] dp = new boolean[num + 1];
        dp[1] = false;

        for (int i = 2; i <= num; i++) {
            if (i - 1 >= 0 && !dp[i - 1]) {
                dp[i] = true;
            } else if (i - 2 >= 0 && !dp[i - 2]) {
                dp[i] = true;
            } else if (i - 3 >= 0 && !dp[i - 3]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        return dp[num];
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println(solution(num));
    }
}
