package codingtest2;
import java.util.Arrays;

class Solution02_2 {
    public int[] solution(String myString) {
        String[] splitArr = myString.split("x", -1);

        int[] answer = new int[splitArr.length];

        for (int i = 0; i < splitArr.length; i++) {
            answer[i] = splitArr[i].length();
        }

        return answer;
    }
}

class Solution02_2$2 {
    public int[] solution(String myString) {
        int[] answer = Arrays.stream(myString.split("x", -1))
                .mapToInt(String::length)
                .toArray();

        return answer;
    }
}

/**
 * codingtest2.PrgmTest02_2
 * 2-2. 기초 문제 - X 사이의 개수
 * ---
 * 문자열 myString이 주어집니다.
 * myString을 문자 "x"를 기준으로 나눴을 때
 * 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을
 * return 하는 solution 함수를 완성해 주세요.
 */
public class PrgmTest02_2 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        String testStr1 = "oxooxoxxox";
        String testStr2 = "xabcxdefxghi";
        
        System.out.println(Arrays.toString(new Solution02_2().solution(testStr1)));
        System.out.println(Arrays.toString(new Solution02_2().solution(testStr2)));

        System.out.println("=".repeat(50));

        System.out.println(Arrays.toString(new Solution02_2$2().solution(testStr1)));
        System.out.println(Arrays.toString(new Solution02_2$2().solution(testStr2)));
    }
}
