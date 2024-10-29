package pre2_1;

import java.util.HashMap;
import java.util.Map;

public class T1_3 {
    public boolean solution(String p, String s) {
        char[] patterns = p.toCharArray();
        String[] strings = s.split(" ");
        if (patterns.length != strings.length) return false;

        Map<Character, String> charToStrMap = new HashMap<>();
        Map<String, Character> strToCharMap = new HashMap<>();

        for (int i = 0; i < patterns.length; i++) {
            char pattern = patterns[i];
            String string = strings[i];

            if (charToStrMap.containsKey(pattern)) {
                if (!charToStrMap.get(pattern).equals(string)) {
                    return false;
                }
            }
            else charToStrMap.put(pattern, string);

            if (strToCharMap.containsKey(string)) {
                if (strToCharMap.get(string) != pattern) {
                    return false;
                }
            }
            else strToCharMap.put(string, pattern);
        }
        return true;
    }

    public static void main(String[] args) {
        T1_3 t = new T1_3();
        System.out.println(t.solution(
                "가나다라","바나나 드래곤 스리랑카 오염")); // true
        System.out.println(t.solution(
                "갸가갸가","금도끼 은도끼 철도끼 은도끼")); // false
    }
}
