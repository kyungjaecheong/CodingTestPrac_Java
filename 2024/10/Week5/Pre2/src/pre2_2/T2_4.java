package pre2_2;

public class T2_4 {

    public int solution(int[] arr) {
        int answer = 0;

        for (int i : arr) {
            answer ^= i;
        }
        return answer;
    }

    public static void main(String[] args) {
        T2_4 t = new T2_4();
        System.out.println(t.solution(
                new int[]{1, 2, 1}
        )); // 2
        System.out.println(t.solution(
                new int[]{44, 22, 33, 22, 44, 33}
        )); // 0
    }
}
