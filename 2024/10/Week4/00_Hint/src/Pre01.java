import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 힌트 문제 1 - 수학
 * ---
 * 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을
 * return하도록 solution 함수를 완성해주세요.
 */
public class Pre01 {

    public static int[] solution(int n) {
        return IntStream.range(1, n+1).filter(x -> x%2 != 0).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10)));
        // 1,3,5,7,9

        System.out.println(Arrays.toString(solution(15)));
        // 1,3,5,7,9,11,13,15
    }
}
