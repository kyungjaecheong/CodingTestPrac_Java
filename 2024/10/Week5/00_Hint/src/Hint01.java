import java.util.Map;
import java.util.TreeMap;

/**
 * 힌트 1 - 해시테이블
 * ---
 * 문자열 s가 매개변수로 주어집니다.
 * s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을
 * return 하도록 solution 함수를 완성해보세요.
 * 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
 * ---
 * s는 소문자로만 이루어져 있습니다.
 */
public class Hint01 {

    public String solution(String s) {
        Map<Character, Integer> cntMap = new TreeMap<>();
        for (char c : s.toCharArray()) {
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 1) sb.append(entry.getKey());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Hint01 h = new Hint01();
        System.out.println(h.solution("abcabcadc"));// d
        System.out.println(h.solution("abdc"));     // abcd
        System.out.println(h.solution("hello"));    // eho
    }
}
