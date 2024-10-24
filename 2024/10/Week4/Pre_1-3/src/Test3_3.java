import java.util.ArrayDeque;
import java.util.Deque;

public class Test3_3 {

    public int solution(String S) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Test3_3 t = new Test3_3();
        System.out.println(t.solution("ABBA"));
    }
}
