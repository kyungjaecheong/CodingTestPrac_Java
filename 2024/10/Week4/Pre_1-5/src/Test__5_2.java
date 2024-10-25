public class Test__5_2 {

    public boolean solution(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i*i <= n; i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Test__5_2 t = new Test__5_2();
        System.out.println(t.solution(7)); // true
    }
}
