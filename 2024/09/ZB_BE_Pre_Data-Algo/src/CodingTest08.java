import java.io.*;

/**
 * 08.히스토그램
 * ---
 * 첫 번째 줄에는 테스트 케이스의 개수 n (1 ≤ n ≤ 100)이 주어진다.
 * 다음 n 개의 줄에는 각 히스토그램의 크기 k (1 ≤ k ≤ 80)가 주어진다.
 * ---
 * 각 테스트 케이스에 대해서 히스토그램의 크기 k와 동일한 수의 '='를 출력한다.
 * '='사이에 공백은 존재하지 않는다.
 */
public class CodingTest08 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] kArr = new int[n];
        for (int i = 0; i  < n; i++) {
            kArr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < kArr[k]; i++) {
                bw.write("=");
            }
            if (k != n - 1) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
