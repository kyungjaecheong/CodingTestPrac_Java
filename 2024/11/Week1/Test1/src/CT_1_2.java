import java.util.*;

public class CT_1_2 {

    public int solution(String[] names) {
        int answer = 0;

        Set<String> uniqueNames = new HashSet<>();
        Collections.addAll(uniqueNames, names);

        int n = uniqueNames.size();
        int r = 4;

        if (n < r) return 0;

        return combination(n, r);
    }

    private int combination(int n, int r) {
        if (r > n) return 0;
        int result = 1;

        for (int i = 0; i < r; i++) {
           result *= (n - i);
           result /= (i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        CT_1_2 t = new CT_1_2();
        System.out.println(t.solution(new String[]
                {"제로", "베이스", "자바", "스쿨", "자바",
                "베이스", "베이스", "백엔드", "화이팅"})); // 15
    }
}
