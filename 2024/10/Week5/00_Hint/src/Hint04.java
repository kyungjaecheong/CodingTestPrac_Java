/**
 * 힌트 4 - 문자열
 * ---
 * 문자열 str1, str2가 매개변수로 주어집니다.
 * str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.
 */
public class Hint04 {
    public int solution(String str1, String str2) {
        if (str1.contains(str2)) return 1;
        else return 2;
    }

    public static void main(String[] args) {
        Hint04 h = new Hint04();
        System.out.println(h.solution("ab6CDE443fgh22iJKlmn1o","6CD")); // 1
        System.out.println(h.solution("ppprrrogrammers","pppp")); // 2
        System.out.println(h.solution("AbcAbcA","AAA")); // 2
    }
}
