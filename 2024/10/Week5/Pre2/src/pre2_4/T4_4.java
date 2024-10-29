package pre2_4;

import java.util.HashMap;
import java.util.Map;

public class T4_4 {

    public int solution(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;

        for (int count : countMap.values()) {
            if (count > 1) {
                pairs += count * (count - 1) / 2;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        T4_4 t = new T4_4();
        System.out.println(t.solution(
                new int[]{2, 5, 6, 3, 2, 6, 6}
        )); // 4
    }
}
