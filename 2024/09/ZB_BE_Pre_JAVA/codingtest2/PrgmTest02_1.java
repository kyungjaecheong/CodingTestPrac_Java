package codingtest2;
import java.util.Arrays;


class Solution02_1 {
    public String[] solution(String my_string) {
        String[] answer = my_string.split(" ");
        return answer;
    }
}

/**
 * codingtest2.PrgmTest02_1
 * 2-1. 기초 문제 - 공백으로 구분하기 1
 * ---
 * 단어가 공백 한 개로 구분되어 있는 문자열 my_string이 매개변수로 주어질 때,
 * my_string에 나온 단어를 앞에서부터 순서대로 담은 문자열 배열을
 * return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest02_1 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        String testString1 = "i love you";
        String testString2 = "programmers";

        System.out.println(Arrays.toString(new Solution02_1().solution(testString1)));
        System.out.println(Arrays.toString(new Solution02_1().solution(testString2)));
    }
}
