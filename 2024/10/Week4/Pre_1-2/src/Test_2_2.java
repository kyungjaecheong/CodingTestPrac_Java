import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_2_2 {

    public static String[] solution(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder currWord = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                currWord.append(c);
            } else {
                if (currWord.length() > 0) {
                    words.add(currWord.reverse().toString());
                    currWord.setLength(0);
                }
            }
        }

        if (currWord.length() > 0) {
            words.add(currWord.reverse().toString());
        }

        return words.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("Hello, World!?.")));
    }
}
