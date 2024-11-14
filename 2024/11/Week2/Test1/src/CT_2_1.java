import java.util.Arrays;

public class CT_2_1 {

    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer = numbers[0];

        for (int number : numbers) {
            if (number == answer) answer++;
            else break;
        }
        return answer;
    }

    public static void main(String[] args) {
        CT_2_1 t = new CT_2_1();
        System.out.println(t.solution(
                new int[]{9, 4, 2, 3, 7, 5}
        )); // 6
    }
}
