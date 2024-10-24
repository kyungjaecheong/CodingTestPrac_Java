public class Test3_4 {

    public int solution(String s) {
        int answer = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num *= 10;
                num += (c-'0');
            } else if (c == '+') {
                answer += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                answer += sign * num;
                num = 0;
                sign = -1;
            }
        }

        answer += sign * num;

        return answer;
    }

    public static void main(String[] args) {
        Test3_4 t = new Test3_4();
        System.out.println(t.solution("-3+26-7")); // 16
    }
}
