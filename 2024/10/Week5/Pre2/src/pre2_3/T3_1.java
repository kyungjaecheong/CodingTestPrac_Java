package pre2_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T3_1 {

    public String solution(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(
                freqMap.entrySet()
        );

        entryList.sort((a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return a.getKey() - b.getKey();
            }
            return b.getValue() - a.getValue();
        });

        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            ans.append(entry.getKey()).append(" ");
        }

        for (char c = '0'; c <= '9'; c++) {
            if (!freqMap.containsKey(c)) ans.append(c).append(" ");
        }

        return ans.deleteCharAt(ans.length()-1).toString();
    }

    public static void main(String[] args) {
        T3_1 t = new T3_1();
        System.out.println(t.solution("221123"));
        // 2, 1, 3, 0, 4, 5, 6, 7, 8, 9
    }
}
