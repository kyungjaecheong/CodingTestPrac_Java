public class CT_1_1 {

    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        CT_1_1 t = new CT_1_1();
        System.out.println(t.solution(15)); //6
    }
}
