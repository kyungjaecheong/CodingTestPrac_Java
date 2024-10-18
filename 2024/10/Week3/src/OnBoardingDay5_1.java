import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Day5 - 필수문제
 * 요세푸스 문제
 * ---
 * 요세푸스 문제는 다음과 같다.
 * - 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고,
 *   양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.
 * - 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
 * - 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
 * - 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
 * - 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 * ---
 * 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
 * ---
 * 예제 입출력
 * 입력 : 7 3
 * 출력 : <3, 6, 2, 7, 5, 1, 4>
 */
public class OnBoardingDay5_1 {

    /* 풀이 1 (LinkedList 활용) -> 이걸 공유해야함
    public static void main(String[] args) throws IOException {

        final int N = getPosInt();
        final int K = getPosInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int n = 1; n <= N; n++) {
            queue.offer(n);
        }

        StringBuilder sb = new StringBuilder().append("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.delete(sb.length()-2, sb.length()).append(">");

        System.out.println(sb);
    }
     */

    /* 풀이 2 (성능 개선)
    public static void main(String[] args) throws  IOException{
        final int N = getPosInt();
        final int K = getPosInt();

        List<Integer> list = new ArrayList<>();
        for (int n = 1; n <= N; n++) {
            list.add(n);
        }

        StringBuilder sb = new StringBuilder().append("<");

        int index = 0;
        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            sb.append(list.remove(index));
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
     */

    /* 풀이 3 (LinkedList로 바꿔서 개선) - 이걸 공유해도 될듯
     */
    public static void main(String[] args) throws  IOException{
        final int N = getPosInt();
        final int K = getPosInt();

        List<Integer> list = new LinkedList<>();
        for (int n = 1; n <= N; n++) {
            list.add(n);
        }

        StringBuilder sb = new StringBuilder().append("<");

        int index = 0;
        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            sb.append(list.remove(index));
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }


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

    /* test Code
    public static void main(String[] args) {
        int[] input = {7, 3};
        testSol(input);
    }

    private static void testSol(int[] input) {
        int n = input[0];
        int k = input[1];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        System.out.println(queue);

        StringBuilder sb = new StringBuilder().append("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(",").append(" ");
        }
        sb.delete(sb.length()-2, sb.length()).append(">");

        System.out.println(sb);
    }
     */

}
