package codingtest3;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

class Solution03_2 {
    public String[] solution(String myStr) {
        List<String> strList = new ArrayList<>();

        String[] splitArr = myStr.split("[abc]");
        for (String str : splitArr) {
            if (!str.isEmpty()) {
                strList.add(str);
            }
        }

        String[] answer;
        if (strList.isEmpty()) {
            answer = new String[] {"EMPTY"};
        } else {
            answer = strList.toArray(new String[0]);
        }

        return answer;
    }
}

class Solution03_2$2 {
    public String[] solution(String myStr) {
        String[] splitArr = Arrays.stream(myStr.split("[abc]"))
                .filter(str -> !str.isEmpty())
                .toArray(String[]::new);

        String[] answer = splitArr.length == 0 ? new String[] {"EMPTY"} : splitArr;

        return answer;
    }
}

/**
 * codingtest3.PrgmTest03_2
 * 3-2. 기초 문제 - 세 개의 구분자
 * ---
 * 임의의 문자열이 주어졌을 때 문자 "a", "b", "c"를
 * 구분자로 사용해 문자열을 나누고자 합니다.
 * 예를 들어 주어진 문자열이 "baconlettucetomato"라면
 * 나눠진 문자열 목록은 ["onlettu", "etom", "to"] 가 됩니다.
 * 문자열 myStr이 주어졌을 때 위 예시와 같이 "a", "b", "c"를 사용해
 * 나눠진 문자열을 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
 * 단, 두 구분자 사이에 다른 문자가 없을 경우에는 아무것도 저장하지 않으며,
 * return할 배열이 빈 배열이라면 ["EMPTY"]를 return 합니다.
 */
public class PrgmTest03_2 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        String testStr1 = "baconlettucetomato";
        String testStr2 = "abcd";
        String testStr3 = "cabab";

        System.out.println(Arrays.toString(new Solution03_2().solution(testStr1)));
        System.out.println(Arrays.toString(new Solution03_2().solution(testStr2)));
        System.out.println(Arrays.toString(new Solution03_2().solution(testStr3)));

        System.out.println("=".repeat(50));

        System.out.println(Arrays.toString(new Solution03_2$2().solution(testStr1)));
        System.out.println(Arrays.toString(new Solution03_2$2().solution(testStr2)));
        System.out.println(Arrays.toString(new Solution03_2$2().solution(testStr3)));
    }
}
