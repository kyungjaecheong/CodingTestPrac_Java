import java.io.IOException;

/**
 * 힌트 3 - 구현
 * ---
 * 덧셈, 뺄셈, 곱셈, 나눗셈을 할 수 있는 계산기 프로그램을 만드시오.
 * ---
 * 입력의 각 줄에는 숫자와 +, -, *, /, =중 하나가 교대로 주어진다.
 * 첫 번째 줄은 수이다.
 * 연산자의 우선 순위는 생각하지 않으며,
 * 입력 순서대로 계산을 하고, =가 주어지면, 그때까지의 결과를 출력한다.
 * 주어지는 수는 10^8 이하의 양의 정수이다.
 * 계산 중 결과는 0 또는 음수가 될 수 있지만, -10^8 ~ 10^8 범위를 넘지는 않는다.
 * 또, 나눗셈에서 소수점은 버린다. 따라서, 100/3*3 = 99이다.
 * 피제수가 음수일 때 나눗셈을 하는 경우는 입력으로 주어지지 않는다.
 */
public class Hint03 {

    public static void main(String[] args) throws IOException {
        int result = getPosInt();

        while (true) {
            char op = getOperator();
            if (op == '=') break;

            int nextInt = getPosInt();

            switch (op) {
                case '+':
                    result += nextInt; break;
                case '-':
                    result -= nextInt; break;
                case '*':
                    result *= nextInt; break;
                case '/':
                    result /= nextInt; break;
            }
        }
        System.out.println(result);
    }

    private static int getPosInt() throws IOException {
        int curInt = 0;
        int cursor;
        boolean hasNumber = false;

        while (true) {
            cursor = System.in.read();
            if (cursor == -1 || cursor == '\n' || cursor == ' '){
                if (hasNumber) break;
                else continue;
            }

            curInt *= 10;
            curInt += (cursor - '0');
            hasNumber = true;
        }
        return curInt;
    }
    private static char getOperator() throws IOException {
        int cursor;

        while (true) {
            cursor = System.in.read();
            if (cursor == '='
                    || cursor == '+'
                    || cursor == '-'
                    || cursor == '*'
                    || cursor == '/') {
                return (char) cursor;
            }
        }
    }
}
