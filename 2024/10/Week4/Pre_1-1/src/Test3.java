public class Test3 {

    public static int solution(int[] A) {
        if (A.length == 0) return 0;

        int minP = A[0];
        int answer = 0;

        for (int i = 1; i < A.length; i++) {
            int prof = A[i] - minP;

            if (prof > answer) {
                answer = prof;
            }

            if (minP > A[i]) {
                minP = A[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {100000, 98000, 95000, 98000, 92000};
        System.out.println(solution(A));
    }
}
