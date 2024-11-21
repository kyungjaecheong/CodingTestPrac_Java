public class CT3_1 {

    public int solution(int N, int[][] trust) {
        int[] trustFrom = new int[N + 1];   // 자신을 믿는 사람 수
        int[] trustTo = new int[N + 1];     // 자신이 믿는 사람 수

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            trustTo[a]++;
            trustFrom[b]++;
        }

        for (int i = 1; i <= N; i++) {
            if (trustFrom[i] == N - 1
                    && trustTo[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CT3_1 t = new CT3_1();

        System.out.println(t.solution(
                3, new int[][]{{1, 3}, {2, 3}}
        )); // 3

    }
}
