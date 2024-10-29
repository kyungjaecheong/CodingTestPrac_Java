package pre2_2;

public class T2_1 {

    public int solution(int[] useageArr, int fee) {
        int answer = 0;
        for (int i : useageArr) {
            answer += i * fee;
        }
        return answer;
    }

    public static void main(String[] args) {
        T2_1 t = new T2_1();
        System.out.println(t.solution(
                new int[] {1,3,5}, 5
        )); //45
    }
}
