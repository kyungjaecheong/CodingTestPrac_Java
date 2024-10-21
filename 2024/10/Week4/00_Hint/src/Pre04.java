import java.io.IOException;

/**
 * 힌트 문제 4 - 비트연산자
 * ---
 * 상근이는 초등학교 졸업 여행으로 외계 행성 X3에 방문했었다.
 * 이 행성에 사는 사람들의 이름은 모두 자연수이다.
 * 행성의 거주민은 모두 서로를 알고 있다.
 * 두 X3인은 그들의 친밀도를 자신의 이름을 이진수로 바꾸어서 계산한다.
 * 두 이름을 이진수로 바꾸고, 자리수가 짧은 쪽을 기준으로 정렬한다.
 * 이때, 두 이진수의 각 자리 아래에 두 자리가 같으면 0을, 다르면 1을 적는다.
 * 이 결과 이진수를 다시 10진수로 바꾸면 그들의 친밀도가 된다.
 * =
 * 예를 들어, 10과 19의 친밀도는 25이다.
 * =
 * 행성의 가치는 이 섬에 있는 모든 친밀도의 합이다.
 * 행성 거주민들의 이름이 주어졌을 때, 행성의 가치를 구하는 프로그램을 작성하시오.
 * ---
 * 첫째 줄에 X3 거주민의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 * 다음 N개의 줄에는 거주민의 이름이 주어진다.
 * 이름은 1,000,000보다 작거나 같은 자연수이다.
 * ---
 * 첫째 줄에 행성 X3의 가치를 출력한다.
 */
public class Pre04 {

    public static void main(String[] args) throws IOException {
        int N = getPosInt();
        int[] residents = new int[N];
        for (int i = 0; i < N; i++) {
            residents[i] = getPosInt();
        }

        long totalValue = 0;

        for (int b = 0; b < 32; b++) {
            long count_0 = 0;
            long count_1 = 0;

            for (int resident : residents) {
                if ((resident & (1 << b)) != 0) {
                    count_1++;
                } else {
                    count_0++;
                }
            }

            totalValue += count_0 * count_1 * (1 << b);
        }
        System.out.println(totalValue);
    }

    private static int getPosInt() throws IOException {
        int curInt = 0;
        int cursor;

        while (true) {
            cursor = System.in.read();
            if (cursor == -1
                || cursor == '\n'
                || cursor == ' ') break;

            curInt *= 10;
            curInt += (cursor - '0');
        }
        return curInt;
    }

    /* 테스트 1
    private static long countX3(int[] arr) {
        long totalValue = 0;

        for (int bit = 0; bit < 32; bit++) {
            long count_1 = 0;
            long count_0 = 0;

            for (int resident : arr) {
                if ((resident & (1 << bit)) != 0) {
                    count_1++;
                } else {
                    count_0++;
                }
            }

            totalValue += count_1 * count_0 * (1 << bit);
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] test1 = {19, 10};
        int[] test2 = {7, 3, 5};
        int[] test3 = {9, 13, 1, 9, 6};

        System.out.println(countX3(test1));
        System.out.println(countX3(test2));
        System.out.println(countX3(test3));
    }
     */

}
