import java.util.Arrays;

/**
 * 힌트 2 - 배열
 * ---
 * 정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다.
 * 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을
 * return하도록 solution 함수를 완성해주세요.
 * - 3 ≤ numbers의 길이 ≤ 20
 * - direction은 "left" 와 "right" 둘 중 하나입니다.
 */
public class Hint02 {

    public int[] solution(int[] numbers, String direction) {
        int length = numbers.length;
        int[] result = new int[length];

        if (direction.equals("right")) {
            System.arraycopy(
                    numbers, length -1,
                    result, 0, 1);
            System.arraycopy(
                    numbers, 0,
                    result, 1, length-1);
        } else if (direction.equals("left")) {
            System.arraycopy(
                    numbers, 0,
                    result, length-1, 1);
            System.arraycopy(
                    numbers, 1,
                    result, 0, length-1);
        }

        return result;
    }

    public static void main(String[] args) {
        Hint02 h = new Hint02();
        int[] num1 = {1, 2, 3};
        int[] num2 = {4, 455, 6, 4, -1, 45, 6};
        System.out.println(Arrays.toString(h.solution(num1, "right")));
        System.out.println(Arrays.toString(h.solution(num2, "left")));
    }
}
