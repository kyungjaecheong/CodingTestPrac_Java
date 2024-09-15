/**
 * 02. 접미사인지 확인하기
 * ---
 * 어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
 * 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
 * 문자열 my_string과 is_suffix가 주어질 때, is_suffix가 my_string의 접미사라면 1을,
 * 아니면 0을 return 하는 solution 함수를 작성해 주세요.
 */
public class CodingTest02 {
    public static final String testStr = "banana";

    public static void main(String[] args) {
        // System.out.println("=".repeat(50));
        System.out.println("\n");

        System.out.println(new Solution02().solution(testStr, "ana"));
        System.out.println(new Solution02().solution(testStr, "nan"));
        System.out.println(new Solution02().solution(testStr, "wxyz"));
        System.out.println(new Solution02().solution(testStr, "abanana"));
    }
}

class Solution02 {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;

        int strLen = my_string.length();

        for (int i = strLen-1; i >= 0; i--) {
            String suffix = my_string.substring(i);
            if (suffix.equals(is_suffix)) {
                answer = 1;
                break;
            };
        }

        return answer;
    }
}

// .endsWith() 쓰면 훨씬 간단함...