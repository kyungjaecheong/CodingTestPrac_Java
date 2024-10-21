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
        /* 비활성
        String s = Long.toString(Long.parseLong(biNums[i]) + Long.parseLong(biNums[j]));
        s = s.replace("2", "0");
        result+= Integer.parseInt(s,2);
          int sum = Integer.parseInt(biNums[i], 2) + Integer.parseInt(biNums[j], 2);
        String s = Integer.toBinaryString(sum);
        result += xorByBits(biNums[i], biNums[j]);
        String a = biNums[i];
        String b = biNums[j];
        int maxLength = Math.max(a.length(), b.length());
        a = String.format("%" + maxLength + "s", a).replace(' ', '0');
        b = String.format("%" + maxLength + "s", b).replace(' ', '0');

        StringBuilder xorResult = new StringBuilder();
        for (int k = 0; k < maxLength; k++) {
          char bitA = a.charAt(k);
          char bitB = b.charAt(k);

          // XOR 연산
          xorResult.append((bitA == bitB) ? '0' : '1');
        }
        result += Integer.parseInt(xorResult.toString(), 2);
         */
        int xorValue = Integer.parseInt(biNums[i],2) ^ Integer.parseInt(biNums[j], 2);
        result += xorValue;
      }
    }
    System.out.println(result);
  }
  // 두 이진수 문자열을 자리수별로 XOR 연산하는 함수
//  public static int xorByBits(String a, String b) {
//    // 두 문자열의 길이를 맞추기 위해 짧은 쪽을 0으로 채운다
//    int maxLength = Math.max(a.length(), b.length());
//    a = String.format("%" + maxLength + "s", a).replace(' ', '0');
//    b = String.format("%" + maxLength + "s", b).replace(' ', '0');
//
//    StringBuilder xorResult = new StringBuilder();
//
//    // 각 비트를 순회하면서 XOR 연산
//    for (int i = 0; i < maxLength; i++) {
//      char bitA = a.charAt(i);
//      char bitB = b.charAt(i);
//
//      // XOR 연산
//      xorResult.append((bitA == bitB) ? '0' : '1');
//    }
//
//    // XOR 결과를 2진수에서 10진수로 변환 후 반환
//    return Integer.parseInt(xorResult.toString(), 2);
//  }
}
