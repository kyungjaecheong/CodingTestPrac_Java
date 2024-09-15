/**
 * 04.정수 부분
 * ---
 * 실수 flo가 매개 변수로 주어질 때,
 * flo의 정수 부분을 return하도록 solution 함수를 완성해주세요.
 */
public class CodingTest04 {
    public static final double test1 = 1.42;
    public static final double test2 = 69.32;

    public static void main(String[] args) {
        // System.out.println("=".repeat(50));
        System.out.println("\n");

        System.out.println(new Solution04().solution(test1));
        System.out.println(new Solution04().solution(test2));
    }
}


class Solution04 {
    public int solution(double flo) {
        int answer = (int) flo;
        return answer;
    }
}