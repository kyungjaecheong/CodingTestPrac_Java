/**
 * 03. 0떼기
 * ---
 * 정수로 이루어진 문자열 n_str이 주어질 때,
 * n_str의 가장 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을
 * return하도록 solution 함수를 완성해주세요.
 */
public class CodingTest03 {
    public static final String testStr1 = "0010";
    public static final String testStr2 = "854020";

    public static void main(String[] args) {
        // System.out.println("=".repeat(50));
        System.out.println("\n");

        System.out.println(new Solution03().solution(testStr1));
        System.out.println(new Solution03().solution(testStr2));
    }
}

class Solution03 {
    public String solution(String n_str) {
        String answer = String.valueOf(Integer.parseInt(n_str));
        return answer;
    }
}