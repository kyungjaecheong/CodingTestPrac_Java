import java.util.*;

public class T4_3 {
    /* deactive

    public String[][] solution(String[] words, String[] queries) {
        String[][] answer = new String[queries.length][];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            String regex = query.replace("?", "."); // '?'를 정규식 '.'로 변환
            List<String> matchedWords = new ArrayList<>();

            for (String word : words) {
                if (word.matches(regex)) {
                    matchedWords.add(word);
                }
            }

            // 결과 저장
            answer[i] = matchedWords.toArray(new String[0]);
        }

        return answer;
    }
     */

    static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        // 단어를 Trie에 삽입
        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current = current.getChildren().computeIfAbsent(c, k -> new TrieNode());
            }
            current.setEndOfWord(true);
            current.incrementWordCount();
        }

        // 특정 패턴에 매칭되는 단어가 존재하는지 확인
        public boolean matches(String pattern) {
            return searchHelper(pattern, 0, root);
        }

        private boolean searchHelper(String pattern, int index, TrieNode node) {
            if (node == null) return false;
            if (index == pattern.length()) {
                return node.isEndOfWord();
            }

            char c = pattern.charAt(index);
            if (c == '?') {
                for (TrieNode child : node.getChildren().values()) {
                    if (searchHelper(pattern, index + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                return searchHelper(pattern, index + 1, node.getChildren().get(c));
            }
        }
    }

    static class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private boolean endOfWord;
        private int wordCount = 0; // 해당 노드까지 도달하는 단어의 개수

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        public int getWordCount() {
            return wordCount;
        }

        public void incrementWordCount() {
            this.wordCount++;
        }
    }

    public String[][] solution(String[] words, String[] queries) {
        // Trie 구조 초기화
        Map<Integer, Trie> tries = new HashMap<>();
        Map<Integer, Trie> reverseTries = new HashMap<>();

        // Trie에 단어 삽입
        for (String word : words) {
            int length = word.length();
            tries.computeIfAbsent(length, k -> new Trie()).insert(word);

            String reversedWord = new StringBuilder(word).reverse().toString();
            reverseTries.computeIfAbsent(length, k -> new Trie()).insert(reversedWord);
        }

        // 각 쿼리에 대해 매칭 수행
        String[][] answer = new String[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int length = query.length();

            if (!tries.containsKey(length)) {
                answer[i] = new String[0];
                continue;
            }

            if (query.startsWith("?")) {
                // 역방향 탐색
                String reversedQuery = new StringBuilder(query).reverse().toString();
                answer[i] = getMatchingWords(words, reverseTries.get(length), reversedQuery, true);
            } else {
                // 정방향 탐색
                answer[i] = getMatchingWords(words, tries.get(length), query, false);
            }
        }

        return answer;
    }

    // Trie를 이용해 패턴에 매칭되는 단어 반환
    private String[] getMatchingWords(String[] words, Trie trie, String query, boolean isReversed) {
        List<String> matchedWords = new ArrayList<>();
        for (String word : words) {
            String targetWord = isReversed ? new StringBuilder(word).reverse().toString() : word;
            if (word.length() == query.length() && trie.matches(query)) {
                if (matchesPattern(targetWord, query)) {
                    matchedWords.add(word);
                }
            }
        }
        return matchedWords.toArray(new String[0]);
    }

    // 주어진 단어가 패턴과 일치하는지 확인
    private boolean matchesPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char pc = pattern.charAt(i);
            if (pc != '?' && pc != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T4_3 t = new T4_3();
        String[] words = new String[]{
                "hello", "hear", "hell",
                "good", "goose", "children", "card", "teachable"
        };
        String[] queries = new String[]{
                "he??", "g???", "childre?", "goo????", "?"
        };

        String[][] result = t.solution(words, queries);
        for (String[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
