package pre2_4;

public class T4_3 {

    public int solution(String S1, String S2) {
        if (S1.length() != S2.length()) return 0;
        String S1S1 = S1 + S1;
        return S1S1.contains(S2) ? 1 : 0;
    }

    public static void main(String[] args) {
        T4_3 t = new T4_3();
        System.out.println(t.solution("HelloWorld", "WorldHello")); // 1
    }
}
