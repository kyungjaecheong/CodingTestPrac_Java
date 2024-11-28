import java.util.*;

public class T4_1 {

    /* deactive

    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[][] answer = new String[problems.length][];

        for (int i = 0; i < problems.length; i++) {
            String problem = problems[i];
            List<String> matchedTitles = new ArrayList<>();

            for (int j = 0; j < lyrics.length; j++) {
                if (lyrics[j].replaceAll("[^가-힣a-zA-Z0-9]", "").startsWith(problem)) {
                    matchedTitles.add(titles[j]);
                }
            }

            answer[i] = matchedTitles.toArray(new String[0]);
        }

        return answer;
    }
     */

    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[] processedLyrics = new String[lyrics.length];
        for (int i = 0; i < lyrics.length; i++) {
            processedLyrics[i] = preprocess(lyrics[i]);
        }

        String[][] answer = new String[problems.length][];

        for (int i = 0; i < problems.length; i++) {
            String problem = preprocess(problems[i]);
            List<String> matchedTitles = new ArrayList<>();

            for (int j = 0; j < processedLyrics.length; j++) {
                if (processedLyrics[j].startsWith(problem)) {
                    matchedTitles.add(titles[j]);
                }
            }

            answer[i] = matchedTitles.toArray(new String[0]);
        }

        return answer;
    }

    private String preprocess(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c) || isKorean(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isKorean(char c) {
        return (c >= '가' && c <= '힣');
    }

    public static void main(String[] args) {
        T4_1 t = new T4_1();
        String[] titles = new String[]{
                "아모르파티", "아기상어", "올챙이와개구리", "산다는건"};
        String[] lyrics = new String[]{
                "산다는게다그런거지",
                "아기상어뚜루루뚜루",
                "개울가에올챙이한마리",
                "산다는건다그런거래요"};
        String[] problems = new String[]{
                "산다", "아기상어", "올챙이"};
        String[][] result = t.solution(titles, lyrics, problems);
        for (String[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }
}
