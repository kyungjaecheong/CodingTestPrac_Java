import java.util.Arrays;

public class Test4_1 {

    public String solution(int[] arr) {
        byte[] byteArr = new byte[arr.length];
        int idx = 0;
        for (int i : arr) {
            byteArr[idx++] = (byte) i;
        }
        return new String(byteArr);
    }

    public static void main(String[] args) {
        Test4_1 t = new Test4_1();
        int[] testArr = {71, 111, 111, 103, 108, 101};
        System.out.println(t.solution(testArr));
    }
}
