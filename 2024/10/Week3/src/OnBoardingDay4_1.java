import java.io.IOException;

/**
 * Day4 - 필수 문제 (HashMap)
 * 해시 해킹
 * ---
 * ---
 * 그린닷컴의 운영자 연두는 비밀번호를 평문 그대로 저장하는 과오를 뒤로하고,
 * 이제부터 암호에 해시 함수를 적용해 저장하려고 한다.
 * 연두가 아는 해시 함수라고는 알고리즘 문제 풀이에 많이 사용되는
 * 롤링 해시 함수밖에 없기 때문에 이것을 응용하여 사용하기로 했다.
 * -
 * 그린닷컴의 비밀번호 규칙은 꽤 특이한데, 길이가 정확히
 * $N$이어야 하며, 비밀번호를 이루는 문자는 지정된
 * $M$개의 문자 중 하나여야 한다.
 * 따라서, 사용 가능한 각 문자를
 * $0$부터 차례대로 정수에 대응시키면, 비밀번호를 길이가
 * $N$이고 모든 원소가
 * $0$ 이상
 * $M-1$ 이하인 배열
 * $P = [P_0, P_1, \dots, P_{N-1} ]$로 나타낼 수 있다.
 * -
 * 이렇게 비밀번호를 배열
 * $P$로 나타낸 후, 미리 정해진 정수
 * $A$를 이용하여 다음과 같은 해시 함수
 * $h$를 적용한다.
 * -
 * $h(P) = (P_0 \cdot A^0 + P_1 \cdot A^1 + ... + P_{N-1} \cdot A^{N-1}) \mod M$ 
 * -
 * 예를 들어 배열
 * $P = [10, 30, 20], A = 7, M = 55$인 경우를 생각해보자. 이 경우
 * $h(P) = (10 \cdot 7^0 + 30 \cdot 7^1 + 20 \cdot 7^2) \mod 55
 * = (10 + 210 + 980) \mod 55 = 45$이다.
 * 여기서
 * $\bmod$는 나머지 연산으로
 * $1200 = 21 \cdot 55 + 45$이므로
 * $1200 \mod 55 = 45$이다. 따라서 해시값은 항상
 * $0$ 이상
 * $M-1$ 이하의 정수이다.
 * -
 * 그린닷컴 관리자 계정의 비밀번호 해시값을 해킹한 재현이는,
 * 이 해시값으로 실제 비밀번호가 뭐였는지 역추적해보려고 한다.
 * 하지만 그린닷컴에서 사용 가능한 비밀번호는
 * $M^N$개나 있고, 이 중 과연 알아낸 해시값과 일치하는 비밀번호는 몇 개나 될지 궁금해졌다.
 * 여러분이 이것을 대신 구해주자.
 * ---
 * ---
 * 첫째 줄에 비밀번호의 길이
 * $N$과 문자 종류의 개수
 * $M$, 정수
 * $A$가 주어진다. (
 * $1 \le N, M, A \le 5\,000\,000$)
 * -
 * 둘째 줄에 재현이가 알아낸 해시값 정수
 * $H$가 주어진다. (
 * $0 \le H < M$)
 * ---
 * ---
 * 주어진 해시값을 갖는 비밀번호의 개수를 출력한다.
 * 출력하는 값이 너무 커질 수 있으므로, 이것을
 * $1\,000\,000\,007 ( = 10^9 + 7)$로 나눈 나머지를 출력한다.
 */
public class OnBoardingDay4_1 {

    public static void main(String[] args) throws IOException {
        int[] nma = new int[3];
        for (int i = 0; i < 3; i++) {
            nma[i] = getPosInt();
        }
        int H = getPosInt();

        int N = nma[0];
        int M = nma[1];

        long result = 1;

        for (int i = 0; i < N-1; i++) {
            result *= M;
            result %= MOD;
        }

        System.out.println(result);
    }

    private static final int MOD = 1_000_000_007;
    private static int getPosInt() throws IOException {
        int curInt = 0;
        int cursor;

        while (true) {
            cursor = System.in.read();
            if (cursor == -1
                || cursor == ' '
                || cursor == '\n') break;

            curInt *= 10;
            curInt += (cursor - '0');
        }
        return curInt;
    }

    /* test


    public static void main(String[] args) {
        int[] nma = {3, 2, 1};
        int h = 1;
        testSol(nma, h); // 4

        nma = new int[] {5_000_000, 5_000_000, 5_000_000};
        testSol(nma, h); // 73352076
    }

    private static final int MOD = 1_000_000_007;
    private static void testSol(int[] nma, int H) {

        int N = nma[0];
        int M = nma[1];
        int A = nma[2];

        long result = 1;

        for (int i = 0; i < N-1; i++) {
            result *= M;
            result %= MOD;
        }

        System.out.println(result);
    }
     */
}
