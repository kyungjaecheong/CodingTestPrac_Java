package pre2_4;

import java.util.*;

public class T4_2 {

    public int solution(int[] A, int K) {
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    int num = A[i] * 10 + A[j];
                    numberSet.add(num);
                }
            }
        }

        List<Integer> sortedList = new ArrayList<>(numberSet);
        sortedList.sort(Comparator.reverseOrder());

        if (K <= sortedList.size())
            return sortedList.get(K - 1);
        return -1;
    }

    public static void main(String[] args) {
        T4_2 t = new T4_2();
        System.out.println(t.solution(new int[] {1,2,3,4,5}, 1)); // 54
    }
}
