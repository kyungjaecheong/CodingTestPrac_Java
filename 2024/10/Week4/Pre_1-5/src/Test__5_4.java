public class Test__5_4 {

    public int solution(int n) {
        double sqrtVal = Math.sqrt(n);
        if (sqrtVal == (int) sqrtVal) return (int) sqrtVal;
        else return 0;
    }
    public static void main(String[] args) {
        Test__5_4 t = new Test__5_4();
        System.out.println(t.solution(4)); // 2
        System.out.println(t.solution(6)); // 0
    }
}
