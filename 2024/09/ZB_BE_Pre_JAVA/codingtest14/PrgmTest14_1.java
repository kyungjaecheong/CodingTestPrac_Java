package codingtest14;

class Solution14_1 {
    public String solution(String myString) {
        char[] myChars = myString.toCharArray();
        for (int i = 0; i < myChars.length; i++) {
            if (myChars[i] != 'A') {
                myChars[i] = Character.toLowerCase(myChars[i]);
            }
            if (myChars[i] == 'a') {
                myChars[i] = Character.toUpperCase(myChars[i]);
            }
        }
        String answer = new String(myChars);
        return answer;
    }
}

class Solution14_1$2 {
    public String solution(String myString) {
        return myString.toLowerCase().replace('a', 'A');
    }
}

/**
 * 14-1. 기초 문제 - A 강조하기
 * ---
 * 문자열 myString이 주어집니다.
 * myString에서 알파벳 "a"가 등장하면 전부 "A"로 변환하고,
 * "A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환하여
 * return 하는 solution 함수를 완성하세요.
 */
public class PrgmTest14_1 {
    public static final String testStr1 = "abstract algebra";
    public static final String testStr2 = "PrOgRaMmErS";

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(new Solution14_1().solution(testStr1));
        System.out.println(new Solution14_1().solution(testStr2));

        System.out.println("=".repeat(50));

        System.out.println(new Solution14_1$2().solution(testStr1));
        System.out.println(new Solution14_1$2().solution(testStr2));
    }
}
