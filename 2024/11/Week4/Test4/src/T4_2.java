import java.util.Arrays;

public class T4_2 {

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int matchCount = 0;

            if (query.startsWith("*")) {
                // '*'로 시작하는 경우
                String suffix = query.substring(1); // '*' 제거
                for (String word : words) {
                    if (word.endsWith(suffix)) {
                        matchCount++;
                    }
                }
            } else if (query.endsWith("*")) {
                // '*'로 끝나는 경우
                String prefix = query.substring(0, query.length() - 1); // '*' 제거
                for (String word : words) {
                    if (word.startsWith(prefix)) {
                        matchCount++;
                    }
                }
            }

            // 매칭된 개수를 저장
            answer[i] = matchCount;
        }

        return answer;
    }

    public static void main(String[] args) {
        T4_2 t = new T4_2();
        String[] words = new String[]{
                "hello", "hell", "good", "goose", "children", "card", "teachable"
        };
        String[] queries = new String[]{
                "hell*", "goo*", "*able", "qua*"
        };

        System.out.println(Arrays.toString(t.solution(words, queries)));
        // 2, 2, 1, 0

    }
}
