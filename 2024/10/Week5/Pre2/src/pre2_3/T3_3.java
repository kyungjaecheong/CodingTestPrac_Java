package pre2_3;

import java.util.ArrayDeque;
import java.util.Deque;

public class T3_3 {

    public double solution(String S) {
        Deque<Double> numbers = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();

        int i = 0;
        while (i < S.length()) {
            char ch = S.charAt(i);

            if (Character.isDigit(ch)) {
                int j = i;
                while (j < S.length()
                        && (Character.isDigit(S.charAt(j))
                            || S.charAt(j) == '.')) {
                    j++;
                }
                double num = Double.parseDouble(S.substring(i,j));
                numbers.push(num);
                i = j;
            } else {
                while (!operators.isEmpty()
                        && operatorPriority(operators.peek())
                            >= operatorPriority(ch)) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = operators.pop();
                    numbers.push(calculator(a, b, op));
                }
                operators.push(ch);
                i++;
            }
        }

        while (!operators.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char op = operators.pop();
            numbers.push(calculator(a, b, op));
        }
        return Math.floor(numbers.pop() * 100) / 100.0;
    }

    private int operatorPriority(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
    private double calculator(double a, double b, char op) {
        switch (op) {
            case '+' : return a+b;
            case '-' : return a-b;
            case '*' : return a*b;
            case '/' : return a/b;
            default : return 0;
        }
    }

    public static void main(String[] args) {
        T3_3 t = new T3_3();
        System.out.println(t.solution(
                "2*3+5/6*3+15")); //23.50
        System.out.println(t.solution(
                "10/3"
        )); // 3.33
    }
}
