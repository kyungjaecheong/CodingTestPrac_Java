package pre2_4;

public class T4_1 {

    public int solution(int N, int K) {
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n <= N; n++) sb.append(n);

        char target = Character.forDigit(K, 10);
        int count = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == target) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        T4_1 t = new T4_1();
        System.out.println(t.solution(25,2)); // 9
    }
}
