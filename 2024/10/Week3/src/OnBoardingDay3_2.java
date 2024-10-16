import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * array의 각 element 중 divisor로 나누어 떨어지는 값을
 * 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 * ---
 * 제한사항
 * - arr은 자연수를 담은 배열입니다.
 * - 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
 * - divisor는 자연수입니다.
 * - array는 길이 1 이상인 배열입니다.
 */
public class OnBoardingDay3_2 {

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> results = new ArrayList<>();

        for (int num : arr) {
            if (num % divisor == 0) {
                results.add(num);
            }
        }

        if (results.isEmpty()) {
            return new int[] {-1};
        }
        return results.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] testArr1 = {5, 9, 7, 10};
        int divisor1 = 5;
        System.out.println(Arrays.toString(solution(testArr1, divisor1)));

        int[] testArr2 = {1, 2, 3, 36};
        int divisor2 = 1;
        System.out.println(Arrays.toString(solution(testArr2, divisor2)));

        int[] testArr3 = {3, 2, 6};
        int divisor3 = 10;
        System.out.println(Arrays.toString(solution(testArr3, divisor3)));
    }
}
