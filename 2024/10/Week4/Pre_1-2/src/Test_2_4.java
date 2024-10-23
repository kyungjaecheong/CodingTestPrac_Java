
public class Test_2_4 {

    public int solution(int[] orders, int n) {
        int cnt = 0;
        int prevOrder = 0;

        for (int order : orders) {
            int missing = order - prevOrder - 1;

            if (cnt + missing >= n) {
                return prevOrder + (n - cnt);
            }

            cnt += missing;
            prevOrder = order;
        }
        return prevOrder + (n - cnt);
    }

    public static void main(String[] args) {
        Test_2_4 t = new Test_2_4();
        int[] orders = {2, 4, 5, 7};
        int n = 3;
        System.out.println(t.solution(orders, n));

    }
}
