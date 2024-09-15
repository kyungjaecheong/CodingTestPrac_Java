import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * 09.가장 쉬운 문제를 찾는 문제
 * ---
 * 첫째 줄에 문제의 개수 N이 주어진다.
 * 둘째 줄부터 N개의 줄에 문제 제목과 문제 난이도가 공백으로 구분되어 주어진다.
 * ---
 * 가장 쉬운 문제의 제목을 출력한다.
 */
public class CodingTest09 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, String> testMap = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        int minLevel = 4;
        for (int i = 0; i < n; i++) {
            String[] splitInput = br.readLine().split(" ");
            int level = Integer.parseInt(splitInput[1]);
            if (level < minLevel) {
                minLevel = level;
            }
            testMap.put(level, splitInput[0]);
        }
        br.close();

        bw.write(testMap.get(minLevel));

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
