import java.util.HashMap;
import java.util.Map;

/**
 * 힌트 문제 2 - 문자열
 * ---
 * 네오와 프로도가 숫자놀이를 하고 있습니다.
 * 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼
 * 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
 *-
 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
 *-
 * 1478 → "one4seveneight"
 * 234567 → "23four5six7"
 * 10203 → "1zerotwozero3"
 * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나,
 * 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
 * s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
 */
public class Pre02 {

    public static int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder result = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();

        int idx = 0;

        while (idx < s.length()) {
            char currentChar = s.charAt(idx);

            if (Character.isDigit(currentChar)) {
                result.append(currentChar);
                idx++;
            }
            else {
                tempSb.append(currentChar);
                idx++;

                if (map.containsKey(tempSb.toString())) {
                    result.append(map.get(tempSb.toString()));
                    tempSb.setLength(0);
                }
            }
        }
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        String[] strings = {
                "one4seveneight",
                "23four5six7",
                "2three45sixseven",
                "123"
        };

        for (String string : strings) {
            System.out.println(solution(string));
        }
    }
}
