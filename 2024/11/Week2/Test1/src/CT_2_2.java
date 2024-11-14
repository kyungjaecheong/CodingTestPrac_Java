import java.util.*;

public class CT_2_2 {

    public int[] solution(int[] a, int[] b) {
        int maxLen = Math.max(a.length, b.length);
        int[] result = new int[maxLen + 1];

        int carry = 0;
        int aIdx = a.length - 1;
        int bIdx = b.length - 1;

        int resultIdx = maxLen;

        while (aIdx >= 0 || bIdx >= 0 || carry != 0) {
            int aNum = (aIdx >= 0) ? a[aIdx] : 0;
            int bNum = (bIdx >= 0) ? b[bIdx] : 0;

            int sum = aNum + bNum + carry;
            result[resultIdx] = sum % 10;
            carry = sum / 10;

            aIdx--;
            bIdx--;
            resultIdx--;
        }

        if (result[0] == 0) {
            int[] answer = new int[maxLen];
            System.arraycopy(result, 1, answer, 0, maxLen);
            return answer;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        CT_2_2 t = new CT_2_2();
        System.out.println(Arrays.toString(t.solution(
                new int[]{5, 2, 1, 4, 6},
                new int[]{6, 1, 0, 4, 4}
        ))); // 1,1,3,1,9,0
    }
}
