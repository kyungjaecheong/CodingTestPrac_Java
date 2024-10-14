import java.io.*;
import java.util.*;

/**
 * Day1 - 필수문제
 * ---
 * 포스택
 * ---
 * 포닉스는 길이가 $N$인 순열 $A$와 네 개의 비어 있는 스택을 가지고 있다.
 * - 길이가 $N$인 순열이란, $1$ 이상 $N$ 이하의 서로 다른 정수 $N$개가
 *   임의로 나열된 수열을 말한다.
 * - 스택이란 자료구조의 한 종류로 가장 나중에 삽입한 자료가 가장 먼저 나오는
 *   후입선출 (Last In First Out, LIFO)의 특성을 가지고 있다.
 * 포닉스는 PPC를 맞아 더러워진 순열을 청소하려 한다.
 * - 순열을 청소하는 것은 다음과 같은 과정을 통해 순열을
 *   오름차순으로 정렬하는 것을 뜻한다. 즉 순열을 $1, 2, 3, \cdots N$으로 만들어야 한다.
 * 1. 순열 $A$의 원소들을 앞 원소부터 순서대로 네 개의 스택 중 하나에 삽입한다.
 * 2. 순열 $A$의 모든 원소를 스택에 삽입했다면,
 *    네 개 중 원하는 스택에서 수를 꺼내는 것을 반복하여 네 개의 스택에서 모든 수를 꺼낸다.
 * 3. 꺼낸 수들을 꺼낸 순서대로 오른쪽에서 왼쪽으로 나열한다.
 *    즉, 가장 처음에 꺼낸 수가 맨 뒤, 가장 나중에 꺼낸 수가 맨 앞에 위치하게 된다.
 * 포닉스가 주어진 순열을 청소할 수 있는지 판별해 보자.
 * ---
 * 첫째 줄에 순열의 길이 $N$이 주어진다. $(1 ≤ N ≤ 100\,000)$
 * 둘째 줄에 순열 $A$의 원소 $A_i$가 공백으로 구분되어 주어진다.
 * 모든 $A_i$는 $1$ 이상 $N$ 이하의 서로 다른 정수임이 보장된다.
 * ---
 * 포닉스가 순열을 청소할 수 있으면 YES, 불가능하다면 NO를 출력한다.
 */
public class OnBoardingDay1_1 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        br.close();

        int[] aInt = new int[a.length];
        for (int i = 0; i < aInt.length; i++) {
            aInt[i] = Integer.parseInt(a[i]);
        }

        List<Deque<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            stacks.add(new ArrayDeque<>());
        }

        for (int num : aInt) {
            boolean placed = false;

            for (Deque<Integer> stack : stacks) {
                if (stack.isEmpty() || stack.peek() < num) {
                    stack.push(num);
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                bw.write("NO\n");
                bw.flush();
                bw.close();
                return;
            }
        }

        bw.write("YES\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
