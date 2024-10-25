import java.util.ArrayList;
import java.util.List;

public class Test4_3 {

    public int solution(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n ; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n/i) {
                    divisors.add(n/i);
                }
            }
        }
        return divisors.size();
    }

    public static void main(String[] args) {
        Test4_3 t = new Test4_3();
        System.out.println(t.solution(10));
    }
}
