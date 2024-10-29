package pre2_5;

public class T5_4 {

    public int solution(int n) {
        int answer = 0;
        int mod = 1_000_000_007;
        int base = 1;

        for (int i = 0; i < n; i++) {
            answer = (answer + base) % mod;
            base = (base * 2) % mod;
        }

        return answer;
    }

    public static void main(String[] args) {
        T5_4 t = new T5_4();
        System.out.println(t.solution(5)); // 31
    }
}
