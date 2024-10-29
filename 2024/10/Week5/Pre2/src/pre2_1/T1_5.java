package pre2_1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class T1_5 {

    public int[] solution(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new TreeSet<>();
        for (int i : arr1) set1.add(i);

        Set<Integer> set2 = new TreeSet<>();
        for (int i : arr2) set2.add(i);

        set1.retainAll(set2);
        return set1.stream().mapToInt(x->x).toArray();
    }

    public static void main(String[] args) {
        T1_5 t = new T1_5();

        int[] testArr11 = {1, 7, 8, 4};
        int[] testArr12 = {2, 4, 6, 8};
        System.out.println(Arrays.toString(t.solution(testArr11, testArr12)));
        // {4,8}

        int[] testArr21 = {9, 1, 1, 4, 1, 2, 3, 4};
        int[] testArr22 = {5, 6, 10, 12};
        System.out.println(Arrays.toString(t.solution(testArr21, testArr22)));
        // {}
    }
}
