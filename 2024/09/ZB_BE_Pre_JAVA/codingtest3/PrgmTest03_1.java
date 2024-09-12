package codingtest3;

class Solution03_1 {
    public int solution(String binomial) {
        String[] splitArr = binomial.strip().split(" ");
        int num1 = Integer.parseInt(splitArr[0]);
        String operator = splitArr[1];
        int num2 = Integer.parseInt(splitArr[2]);

        int answer = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> 0;
        };

        return answer;
        }
}

/**
 * codingtest3.PrgmTest03_1
 * 3-1. 기초 문제 - 간단한 식 계산하기
 * ---
 * 문자열 binomial이 매개변수로 주어집니다.
 * binomial은 "a op b" 형태의 이항식이고 a와 b는 음이 아닌 정수,
 * op는 '+', '-', '*' 중 하나입니다.
 * 주어진 식을 계산한 정수를 return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest03_1 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        String testString1 = "43 + 12";
        String testString2 = "0 - 7777";
        String testString3 = "40000 * 40000";

        System.out.println(new Solution03_1().solution(testString1));
        System.out.println(new Solution03_1().solution(testString2));
        System.out.println(new Solution03_1().solution(testString3));

    }
}
