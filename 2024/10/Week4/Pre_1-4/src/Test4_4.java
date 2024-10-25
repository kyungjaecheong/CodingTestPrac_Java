public class Test4_4 {

    public String solution(String s) {
        int decimal = Integer.parseInt(s, 16);
        return Integer.toBinaryString(decimal);
    }

    public static void main(String[] args) {
        Test4_4 t = new Test4_4();
        System.out.println(t.solution("f4")); // 11110100
    }
}
