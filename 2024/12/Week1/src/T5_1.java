import java.util.Arrays;

public class T5_1 {

    public boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false; // 길이가 다르면 아나그램이 될 수 없음
        }

        // 각 문자의 빈도를 저장할 배열
        int[] charCounts = new int[26]; // 알파벳 소문자 기준

        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++; // 문자열 s의 문자 개수 증가
        }

        for (char c : t.toCharArray()) {
            charCounts[c - 'a']--; // 문자열 t의 문자 개수 감소

            // 빈도가 음수가 되면 아나그램이 아님
            if (charCounts[c - 'a'] < 0) {
                return false;
            }
        }

        return true; // 모든 문자의 빈도가 동일하면 아나그램
    }

    public static void main(String[] args) {
        T5_1 t = new T5_1();
        String s1 = "imfinethankyou";
        String t1 = "atfhinemnoyuki";
        System.out.println(t.solution(s1, t1)); // true
    }
}
