import java.util.Arrays;

public class Sol_2_1 {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] + 1 != numbers[i + 1]) {
                return numbers[i] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Sol_2_1 t = new Sol_2_1();
        System.out.println(t.solution(
                new int[]{9, 4, 2, 3, 7, 5}
        )); // 6
    }
}
