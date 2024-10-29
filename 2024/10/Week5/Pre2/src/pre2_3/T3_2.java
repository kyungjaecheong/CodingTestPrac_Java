package pre2_3;

import java.util.*;

public class T3_2 {

    public int[] solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        List<Integer> missList = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) missList.add(i);
        }
        return missList.stream().sorted().mapToInt(x->x).toArray();
    }

    public static void main(String[] args) {
        T3_2 t = new T3_2();
        System.out.println(Arrays.toString(t.solution(
                new int[]{1, 2, 3, 4, 6, 6, 6}
        ))); // {5, 7}
        System.out.println(Arrays.toString(t.solution(
                new int[]{1, 3, 4, 8}
        ))); // {2}
    }
}
