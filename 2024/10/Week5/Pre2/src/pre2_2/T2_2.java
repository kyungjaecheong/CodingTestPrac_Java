package pre2_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class T2_2 {

    public int[] solution(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int num : arr) {
            queue.offer(num);
            if (queue.size() == arr.length) break;

            if (num % 2 != 0) {
                queue.offer(num);
                if (queue.size() == arr.length) break;
            }
        }

        int[] answer = new int[arr.length];
        for (int i = 0; i < answer.length; i++) {
            assert !queue.isEmpty();
            answer[i] = queue.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        T2_2 t = new T2_2();
        System.out.println(Arrays.toString(t.solution(
                new int[]{0, 2, 1, 4, 3, 0}
        ))); // {0,2,1,1,4,3}
    }
}
