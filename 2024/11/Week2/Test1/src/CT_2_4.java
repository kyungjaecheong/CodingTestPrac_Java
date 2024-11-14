import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CT_2_4 {

    public int solution(int delay, int capacity, int[] times) {
        int queue = 0; // 현재 큐에 있는 메시지 수
        int lostMessages = 0; // 소실된 메시지 수
        int timeElapsed = 0; // 경과 시간

        for (int t : times) {
            // 경과 시간 갱신
            timeElapsed += t;

            // 큐에서 처리 가능한 메시지 처리
            int processed = timeElapsed / delay;
            queue = Math.max(0, queue - processed);
            timeElapsed %= delay;

            // 새로운 메시지 도착
            queue++;

            // 큐 용량 초과 시 메시지 소실
            if (queue > capacity) {
                lostMessages++;
                queue--;
            }
        }

        return lostMessages;
    }

    public static void main(String[] args) {
        CT_2_4 t = new CT_2_4();
        System.out.println(t.solution(
                5, 5,
                new int[]{3, 2, 0, 0, 2, 3, 0, 0, 2, 2, 5}
        )); // 3
    }
}
