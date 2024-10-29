package pre2_4;

public class T4_5 {

    public int solution(String[] array, String s) {
        int answer = 0;

        for (String string : array) {
            if (s.startsWith(string)) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        T4_5 t = new T4_5();
        System.out.println(t.solution(
                new String[] {"n", "nav", "nev"}, "naver"
        )); // 2
    }
}
