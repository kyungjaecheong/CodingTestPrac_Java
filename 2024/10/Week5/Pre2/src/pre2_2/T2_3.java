package pre2_2;

public class T2_3 {

    public int solution(int n) {
        int x = (int) Math.cbrt(n);
        return x * x * x;
    }

    public static void main(String[] args) {
        T2_3 t = new T2_3();
        System.out.println(t.solution(15)); // 8
        System.out.println(t.solution(99)); // 64
    }
}
