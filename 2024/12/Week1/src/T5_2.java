import java.util.Arrays;

public class T5_2 {

    public String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 정렬하는 비교자를 사용하여 내림차순으로 정렬
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        // 0만 여러 개 포함된 경우 0만 리턴
        if (numStrs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        T5_2 t = new T5_2();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(t.solution(nums)); // "9534330"
    }
}
