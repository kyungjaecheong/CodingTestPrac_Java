public class Test__5_3 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Test__5_3 t = new Test__5_3();
        System.out.println(t.solution("apple"));
    }
}
