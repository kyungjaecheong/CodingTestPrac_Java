package codingtest6;

class Solution06_2 {
    public int solution(int num, int n) {
        int answer = (num % n == 0) ? 1 : 0;
        return answer;
    }
}

/**
 * codingtest6.PrgmTest06_2
 * 6-2. 기초 문제 - n의 배수
 * ---
 * 정수 num과 n이 매개 변수로 주어질 때,
 * num이 n의 배수이면 1을 return n의 배수가 아니라면 0을
 * return하도록 solution 함수를 완성해주세요.
 */
public class PrgmTest06_2 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        int[] testInt1 = {98, 2};
        int[] testInt2 = {34, 3};

        System.out.println(new Solution06_2().solution(testInt1[0], testInt1[1]));
        System.out.println(new Solution06_2().solution(testInt2[0], testInt2[1]));

    }
}
