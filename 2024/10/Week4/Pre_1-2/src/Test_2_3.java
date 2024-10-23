public class Test_2_3 {

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public int solution(int[] A) {
        int answer = A[0];
        for (int i = 1; i < A.length; i++) {
            answer = gcd(answer, A[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {6, 12, 4};
        Test_2_3 sol = new Test_2_3();
        System.out.println(sol.solution(A));
    }
}
