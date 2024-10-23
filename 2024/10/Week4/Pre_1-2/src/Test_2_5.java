import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test_2_5 {

    public int solution(int[] arr) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparing(Math::abs));

        for (int i : arr) {
            pq.offer(i);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 3};
        Test_2_5 t = new Test_2_5();
        System.out.println(t.solution(arr));

    }
}
