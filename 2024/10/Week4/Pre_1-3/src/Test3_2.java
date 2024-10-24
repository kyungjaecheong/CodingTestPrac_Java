import java.util.ArrayDeque;
import java.util.Deque;

public class Test3_2 {

    public int solution(String S) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : S.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return 0;

                char open = stack.pop();
                if ((c == ')' && open != '(')
                    || (c == '}' && open != '{')
                    || (c == ']' && open != '[')
                    || (c == '>' && open != '<')
                ) return 0;
            }
        }

        if (stack.isEmpty()) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Test3_2 t = new Test3_2();
        String test1 = "(()){[<>]}";
        System.out.println(t.solution(test1)); // 1
        String test2 = "({)}[<]>";
        System.out.println(t.solution(test2)); // 0

    }
}
