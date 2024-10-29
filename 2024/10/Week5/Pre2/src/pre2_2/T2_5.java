package pre2_2;

public class T2_5 {

    public int solution(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        boolean isMinus = false;
        if (sb.charAt(0) == '-') {
            isMinus = true;
            sb.deleteCharAt(0);
        }
        int reversed = Integer.parseInt(sb.reverse().toString());
        if (reversed >= 100_000) return 0;
        return isMinus ? -reversed : reversed;
    }

    public static void main(String[] args) {
        T2_5 t = new T2_5();
        System.out.println(t.solution(340)); // 43
        System.out.println(t.solution(-587)); // -785
    }
}
