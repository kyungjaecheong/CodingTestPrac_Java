import java.util.ArrayDeque;
import java.util.Deque;

public class Test3_1 {

    public String solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Test3_1 t = new Test3_1();

        System.out.println(t.solution("aacddefg")); // cefg
    }
}
