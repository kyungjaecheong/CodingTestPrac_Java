package pre2_3;

import java.util.ArrayDeque;
import java.util.Deque;

public class T3_5 {

    public int solution(int N, int K) {
        Deque<Integer> table = new ArrayDeque<>();
        for (int n = 1; n <= N; n++) table.offer(n);

        int lastNum = -1;
        while (!table.isEmpty()) {
            for (int k = 1; k < K; k++) {
                table.offer(table.poll());
            }
            lastNum = table.poll();
        }
        return lastNum;
    }

    public static void main(String[] args) {
        T3_5 t = new T3_5();
        System.out.println(t.solution(7,3)); // 4
    }
}
