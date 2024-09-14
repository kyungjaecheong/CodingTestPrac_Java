package codingtest11;

class Solution11_2 {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();

        for (int i = c-1; i < my_string.length(); i += m) {
            sb.append(my_string.charAt(i));
        }

        String answer = sb.toString();
        return answer;
    }
}

/**
 * 11-2. 기초 문제 - 세로 읽기
 * ---
 * 문자열 my_string과 두 정수 m, c가 주어집니다.
 * my_string을 한 줄에 m 글자씩 가로로 적었을 때
 * 왼쪽부터 세로로 c번째 열에 적힌 글자들을 문자열로
 * return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest11_2 {
    public static final String testStr1 = "ihrhbakrfpndopljhygc";
    public static final int[] testInts1 = {4,2};
    public static final String testStr2 = "programmers";
    public static final int[] testInts2 = {1,1};

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(new Solution11_2().solution(
                testStr1, testInts1[0], testInts1[1]
        ));
        System.out.println(new Solution11_2().solution(
                testStr2, testInts2[0], testInts2[1]
        ));
    }
}
