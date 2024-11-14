import java.util.*;

public class CT_2_3 {

    public String solution(String code) {
        Deque<String> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        StringBuilder currentStr = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);

            if (Character.isDigit(ch)) {
                numStack.push(ch - '0');
            } else if (ch == '{') {
                strStack.push(currentStr.toString());
                currentStr = new StringBuilder();
            } else if (ch == '}') {
                int repeatCnt = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());

                for (int j = 0; j < repeatCnt; j++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
            } else {
                currentStr.append(ch);
            }
        }
        return currentStr.toString();

    }

    public static void main(String[] args) {
        CT_2_3 t = new CT_2_3();
        System.out.println(t.solution(
                "5{he2{l}o}friend"
        )); // hellohellohellohellohellofriend
    }
}
