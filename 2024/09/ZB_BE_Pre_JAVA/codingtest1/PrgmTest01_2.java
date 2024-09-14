package codingtest1;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

class Solution01_2 {
    public String[] solution(String[] strArr) {
        List<String> strList = new ArrayList<>();
        for (String strElement : strArr) {
            if (!strElement.contains("ad")) {
                strList.add(strElement);
            }
        }
        String[] answer = strList.toArray(new String[0]);
        return answer;
    }
}

class Solution01_2$2 {
    public String[] solution(String[] strArr) {
        String[] answer = Arrays.stream(strArr)
                .filter(strElement -> !strElement.contains("ad"))
                .toArray(String[]::new);
        return answer;
    }
}

/**
 * codingtest1.PrgmTest01_2
 * 1-2. 기초 문제 - ad 제거하기
 * ---
 * 문자열 배열 strArr가 주어집니다.
 * 배열 내의 문자열 중 "ad"라는 부분 문자열을 포함하고 있는
 * 모든 문자열을 제거하고 남은 문자열을 순서를 유지하여 배열로
 * return 하는 solution 함수를 완성해 주세요.
 */

public class PrgmTest01_2 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        String[] testInput1 = {"there","are","no","a","ds"};
        String[] result1 = new Solution01_2().solution(testInput1);
        System.out.println(Arrays.toString(result1));

        String[] testInput2 = {"and","notad","abcd"};
        String[] result2 = new Solution01_2().solution(testInput2);
        System.out.println(Arrays.toString(result2));

        System.out.println("=".repeat(50));

        String[] result1$2 = new Solution01_2$2().solution(testInput1);
        System.out.println(Arrays.toString(result1$2));

        String[] result2$2 = new Solution01_2$2().solution(testInput2);
        System.out.println(Arrays.toString(result2$2));
    }
}
