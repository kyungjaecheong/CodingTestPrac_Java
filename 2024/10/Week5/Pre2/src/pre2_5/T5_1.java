package pre2_5;

public class T5_1 {

    public int solution(String sentence, String word) {
        if (sentence.isEmpty() || word.isEmpty()) return -1;
        String[] words = sentence.split(" +");

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        T5_1 t = new T5_1();
        System.out.println(t.solution(
                "Hello every world", "every"
        )); // 1
        System.out.println(t.solution(
                "Hello every world", "ever"
        )); // -1
    }
}
