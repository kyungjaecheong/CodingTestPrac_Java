package pre2_3;

public class T3_4 {

    public int solution(int A, int B) {
        int xor = A^B;

        int count = 0;

        while (xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        T3_4 t = new T3_4();
        System.out.println(t.solution(29, 15)); // 2
    }
}
