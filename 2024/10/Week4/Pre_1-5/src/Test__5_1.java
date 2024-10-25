import java.util.Map;
import java.util.TreeMap;

public class Test__5_1 {

    public String solution(String s) {
        Map<Character, Integer> map = new TreeMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        String mostFreqChar = null;
        int maxCnt = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCnt) {
                mostFreqChar = entry.getKey().toString();
                maxCnt = entry.getValue();
            }
        }

        return mostFreqChar;
    }

    public static void main(String[] args) {
        Test__5_1 t = new Test__5_1();
        System.out.println(t.solution("google"));
    }
}
