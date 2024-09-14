package codingtest7;

class Solution07_1 {
    public int solution(int a, int b, boolean flag) {
        if (flag) {
            return a + b;
        }
        return a - b;
    }
}

/**
 * codingtest6.PrgmTest07_1
 * 7-1. 기초 문제 - flag에 따라 다른 값 반환하기
 * ---
 * 두 정수 a, b와 boolean 변수 flag가 매개변수로 주어질 때,
 * flag가 true면 a + b를 false면 a - b를
 * return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest07_1 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        int[] testInt1 = {-4, 7};
        int[] testInt2 = {-4, 7};

        System.out.println(new Solution07_1().solution(testInt1[0], testInt1[1], true));
        System.out.println(new Solution07_1().solution(testInt2[0], testInt2[1], false));

    }
}
