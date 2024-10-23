public class Test1 {

    public static int solution(int n) {
        int answer = n * (n + 1) / 2;
        return answer;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
}
