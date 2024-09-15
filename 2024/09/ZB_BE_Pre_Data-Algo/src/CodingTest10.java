import java.io.*;

/**
 * 10.백발백준하는 명사수
 * ---
 * 첫번째 줄에는 첫번째 과녁의 중심 X1, Y1와 반지름 R1이 주어진다.
 * 두번째 줄에는 두번째 과녁의 중심 X2, Y2와 반지름 R2가 주어진다.
 * X1, X2, Y1, Y2는 모두 정수이며, R1, R2는 모두 자연수이다.
 * -109 ≤ X1, X2, Y1, Y2 ≤ 109, 0 < R1, R2 ≤ 109
 * ---
 * 두 과녁이 겹치면 YES, 아니면 NO를 출력한다.
 * 단, 두 과녁이 한 점에서 만나는 경우는 겹치지 않는 것으로 생각한다.
 */
public class CodingTest10 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        br.close();

        double distance = Math.sqrt(
                Math.pow(Double.parseDouble(input2[0]) - Double.parseDouble(input1[0]),2)
                + Math.pow(Double.parseDouble(input2[1]) - Double.parseDouble(input1[1]),2)
        );
        double sumRad = Double.parseDouble(input2[2]) + Double.parseDouble(input1[2]);

        if (distance < sumRad) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
