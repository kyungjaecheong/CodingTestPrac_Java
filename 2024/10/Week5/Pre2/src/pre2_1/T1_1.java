package pre2_1;

import java.util.Arrays;

public class T1_1 {

    public int solution(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 2; i--) {
            if (arr[i] < arr[i - 1] + arr[i - 2]) {
                return arr[i] + arr[i - 1] + arr[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        T1_1 t = new T1_1();
        int[] testArr1 = {6, 2, 12, 8, 5, 9}; // 29
        int[] testArr2 = {5, 19, 4, 23, 198, 34}; // 76
        int[] testArr3 = {1, 2, 5, 60, 50, 7}; // 0
        System.out.println(t.solution(testArr1));
        System.out.println(t.solution(testArr2));
        System.out.println(t.solution(testArr3));
    }
}
