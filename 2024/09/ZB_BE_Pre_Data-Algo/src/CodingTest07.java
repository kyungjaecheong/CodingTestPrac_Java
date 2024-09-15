import java.io.*;

/**
 * 07.5의 수난
 * ---
 * 첫째 줄에 다섯 자리인 양의 정수 $n$이 주어진다.
 * 주어지는 $n$은 $10^{4} \leq n < 10^{\mathbf{5}}$을 만족한다.
 * ---
 * 첫째 줄에 각 자릿수의 다섯제곱의 합을 출력하라.
 */
public class CodingTest07 {
    // 입력예시 : 12345, 54748, 92727, 93084
    // 출력예시 : 4425, 54748, 92727, 93084

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] inputChars = br.readLine().toCharArray();
        int sumPow5 = 0;

        for (char c : inputChars) {
            sumPow5 += (int) Math.pow(Integer.parseInt(String.valueOf(c)), 5);
        }

        bw.write(String.valueOf(sumPow5));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
