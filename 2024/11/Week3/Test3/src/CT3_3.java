import java.util.*;

public class CT3_3 {

    public int solution(int delay, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;

        while (!queue.isEmpty()) {
            int currentTime = queue.poll();
            if (currentTime < N) {
                queue.add(currentTime + 1);
                queue.add(currentTime + delay + 1);
            }
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        CT3_3 t = new CT3_3();
        System.out.println(t.solution(1,2)); // 5
        System.out.println(t.solution(2, 5)); // 17

    }
}
