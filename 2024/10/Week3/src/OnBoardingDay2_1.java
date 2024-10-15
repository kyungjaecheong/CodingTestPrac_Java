import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day2 - 필수문제
 * 회전하는 큐
 * ---
 * 지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다.
 * 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.
 * 지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
 * - 첫 번째 원소를 뽑아낸다.
 *   이 연산을 수행하면, 원래 큐의 원소가
 *   a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
 * - 왼쪽으로 한 칸 이동시킨다.
 *   이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
 * - 오른쪽으로 한 칸 이동시킨다.
 *   이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
 * 큐에 처음에 포함되어 있던 수 N이 주어진다.
 * 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다.
 * (이 위치는 가장 처음 큐에서의 위치이다.)
 * 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는
 * 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
 * ---
 * 첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다.
 * N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다.
 * 둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다.
 * 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.
 * ---
 * 첫째 줄에 문제의 정답을 출력한다.
 */
public class OnBoardingDay2_1 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmStr = br.readLine().split(" ");
        String[] positionStr = br.readLine().split(" ");
        br.close();

        int n = Integer.parseInt(nmStr[0]);
        int m = Integer.parseInt(nmStr[1]);
        int[] positions = new int[m];
        for (int i = 0; i < m; i++) {
            positions[i] = Integer.parseInt(positionStr[i]);
        }

        int operationCnt = getOperationCnt(n, positions);

        bw.write(String.format("%d\n", operationCnt));
        bw.flush();
        bw.close();

    }

    private static int getOperationCnt(int n, int[] positions) {
        int operationCnt = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        for (int target : positions) {
            int targetIdx = 0;

            for (int dNum : deque) {
                if (dNum == target) {
                    break;
                }
                targetIdx++;
            }

            int frontSize = targetIdx;
            int rearSize = deque.size() - targetIdx;

            if (frontSize < rearSize) {
                for (int i = 0; i < frontSize; i++) {
                    deque.offer(deque.poll());
                    operationCnt++;
                }
            } else {
                for (int i = 0; i < rearSize; i++) {
                    deque.offerFirst(deque.pollLast());
                    operationCnt++;
                }
            }

            deque.poll();
        }
        return operationCnt;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }


    /* deactive


    public static void main(String[] args) {
        int[] mn1 = {10, 3};
        int[] pos1 = {1, 2, 3};
        testSol(mn1, pos1); // 0
        System.out.println();

        int[] mn2 = {10, 3};
        int[] pos2 = {2, 9, 5};
        testSol(mn2, pos2); // 8
        System.out.println();

        int[] mn3 = {32, 6};
        int[] pos3 = {27, 16, 30, 11, 6, 23};
        testSol(mn3, pos3); // 59
        System.out.println();

        int[] mn4 = {10, 10};
        int[] pos4 = {1, 6, 3, 2, 7, 9, 8, 4, 10, 5};
        testSol(mn4, pos4); // 14
        System.out.println();

    }

    private static void testSol(int[] mn, int[] pos) {

        int n = mn[0]; // Queue size
        int m = mn[1]; // elements to pick

        // Initialize
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int totalOperations = 0;

        for (int i = 0; i < m; i++) {
            int target = pos[i];
            int idx = 0;

            for (int elem : deque) {
                if (elem == target) {
                    break;
                }
                idx++;
            }

            int leftRotations = idx;
            int rightRotations = deque.size() - idx;

            if (leftRotations <= rightRotations) {
                for (int j = 0; j < leftRotations; j++) {
                    deque.offerLast(deque.pollFirst());
                }
                totalOperations += leftRotations;
            } else {
                for (int j = 0; j < rightRotations; j++) {
                    deque.offerFirst(deque.pollLast());
                }
                totalOperations += rightRotations;
            }

            deque.poll();
        }

        System.out.println(totalOperations);
    }
     */
}
