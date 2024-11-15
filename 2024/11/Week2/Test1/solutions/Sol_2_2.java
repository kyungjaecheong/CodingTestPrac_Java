import java.util.Arrays;
import java.util.Stack;

public class Sol_2_2 {

    public int[] solution(int[] a, int[] b) {

        Stack<Integer> stack = new Stack<>();
        int maxLen = Math.max(a.length, b.length);
        int offsetA = maxLen - a.length;
        int offsetB = maxLen - b.length;

        if (a.length == 0) return b;
        if (b.length == 0) return a;

        int overflow = 0;
        for (int i = maxLen - 1; i >= 0; i--) {
            int aVal = (i - offsetA < 0) ? 0 : a[i - offsetA];
            int bVal = (i - offsetB < 0) ? 0 : b[i - offsetB];
            int cVal = aVal + bVal + overflow;
            if (cVal >= 10) {
                overflow = 1;
                stack.push(cVal - 10);
            } else {
                overflow = 0;
                stack.push(cVal);
            }
        }

        int resLen = maxLen;
        if (overflow == 1) {
            resLen++;
            stack.push(1);
        }

        int[] result = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Sol_2_2 t = new Sol_2_2();
        System.out.println(Arrays.toString(t.solution(
                new int[]{5, 2, 1, 4, 6},
                new int[]{6, 1, 0, 4, 4}
        ))); // 1,1,3,1,9,0
    }
}
