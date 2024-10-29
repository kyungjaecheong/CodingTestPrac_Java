package pre2_1;

import java.util.Arrays;

public class T1_2 {

    public int solution(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int max = -1;
        int sum = 0;

        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
            sum += i;
        }

        int excludeSum = sum - max - min;
        return excludeSum / (arr.length - 2);
    }

    public static void main(String[] args) {
        T1_2 t = new T1_2();
        int[] testArr1 = {2, 3, 3, 3, 20}; // 3
        int[] testArr2 = {9, 4, 7, 5, 10, 4}; // 6
        System.out.println(t.solution(testArr1));
        System.out.println(t.solution(testArr2));
    }
}
