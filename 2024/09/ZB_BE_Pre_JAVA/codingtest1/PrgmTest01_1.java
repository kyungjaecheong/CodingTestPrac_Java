package codingtest1;

class Solution01_1 {
    public String solution(String myString, String pat) {
        String answer = myString.substring(0, myString.lastIndexOf(pat) + pat.length());
        return answer;
    }
}

/**
 * codingtest1.PrgmTest01_1
 * 1-1. 기초 문제 - 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기
 * ---
 * 문자열 myString과 pat가 주어집니다.
 * myString의 부분 문자열중 pat로 끝나는 가장 긴 부분 문자열을 찾아서
 * return 하는 solution 함수를 완성해 주세요.
 */

public class PrgmTest01_1 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        String testString1 = "AbCdEFG";
        String pat1 = "dE";
        String result1 = new Solution01_1().solution(testString1, pat1);
        System.out.println("Test1: " + result1);

        String testString2 = "AAAAaaaa";
        String pat2 = "a";
        String result2 = new Solution01_1().solution(testString2, pat2);
        System.out.println("Test2: " + result2);
    }
}
