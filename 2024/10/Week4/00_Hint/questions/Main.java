import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] biNums = new String[N];
    int result = 0;
    for (int i = 0; i < biNums.length; i++) {
      int n = Integer.parseInt(br.readLine());
      biNums[i] = Integer.toBinaryString(n);
    }
    for (int i = 0; i < biNums.length-1; i++) {
      for (int j = i+1; j < biNums.length; j++) {
        //String s = Integer.toString(Integer.parseInt(biNums[i]) + Integer.parseInt(biNums[j]));
        /* 비활성
          int sum = Integer.parseInt(biNums[i], 2) + Integer.parseInt(biNums[j], 2);
        String s = Integer.toBinaryString(sum);
        s = s.replace("2", "0");
        result+= Integer.parseInt(s,2);
         */
        int xorValue = Integer.parseInt(biNums[i],2) ^ Integer.parseInt(biNums[j], 2);
        result += xorValue;
      }
    }
    System.out.println(result);
  }
}
