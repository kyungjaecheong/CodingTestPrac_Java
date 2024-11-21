import java.util.*;

public class CT3_2 {

    public int solution(int[] numbers, int target) {
        // 최소 개수를 저장하는 맵, Dynamic Programming 접근
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int number : numbers) {
                if (number == 0) {
                    // 0인 경우는 건너뜀 (0으로 나누거나 더해봤자 의미 없음)
                    continue;
                }

                // 덧셈 연산
                if (i >= number && dp[i - number] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - number] + 1);
                }

                // 곱셈 연산 (단, i가 number로 나누어떨어지는 경우에만)
                if (i % number == 0 && dp[i / number] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i / number] + 1);
                }
            }
        }

        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }

    public static void main(String[] args) {
        CT3_2 t = new CT3_2();

        System.out.println(t.solution(
                new int[] {1,4,2},
                12
        )); // 3

    }
}
