package codingtest10;

class Solution10_2 {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();

        for (int i : index_list) {
            char c = my_string.charAt(i);
            sb.append(c);
        }
        return sb.toString();
    }
}

/**
 * codingtest10.PrgmTest10_2
 * 10-2. 기초 문제 - 글자 이어 붙여 문자열 만들기
 * ---
 * 문자열 my_string과 정수 배열 index_list가 매개변수로 주어집니다.
 * my_string의 index_list의 원소들에 해당하는 인덱스의 글자들을 순서대로 이어 붙인 문자열을
 * return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest10_2 {
    public static final String testStr1 = "cvsgiorszzzmrpaqpe";
    public static final int[] testIdx1 = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
    public static final String testStr2 = "zpiaz";
    public static final int[] testIdx2 = {1, 2, 0, 0, 3};

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(new Solution10_2().solution(testStr1, testIdx1));
        System.out.println(new Solution10_2().solution(testStr2, testIdx2));
    }
}
