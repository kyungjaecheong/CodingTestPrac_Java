import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test4 {

    public static int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (x,y) -> {
                    if (x.getValue().equals(y.getValue())) {
                        return x.getKey().compareTo(y.getKey());
                    }
                    return y.getValue().compareTo(x.getValue());
                }
        );

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        assert pq.peek() != null;
        return Integer.parseInt(pq.peek().getKey().toString());
    }

    public static void main(String[] args) {
        String s = "552342502";
        System.out.println(solution(s));
    }
}
