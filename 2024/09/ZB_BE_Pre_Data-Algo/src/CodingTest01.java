import java.math.BigInteger;

/**
 * 01. 두 수의 합
 * ---
 * 0 이상의 두 정수가 문자열 a, b로 주어질 때,
 * a + b의 값을 문자열로 return 하는 solution 함수를 작성해 주세요.
 */
public class CodingTest01 {
    public static final String[] testArr1 = {"582", "734"};
    public static final String[] testArr2 = {"18446744073709551615", "287346502836570928366"};
    public static final String[] testArr3 = {"0", "0"};

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(new Solution01().solution(testArr1[0], testArr1[1]));
        System.out.println(new Solution01().solution(testArr2[0], testArr2[1]));
        System.out.println(new Solution01().solution(testArr3[0], testArr3[1]));
    }
}

class Solution01 {
    public String solution(String a, String b) {
        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);
        BigInteger bigSum = bigA.add(bigB);
        String answer = bigSum.toString();
        return answer;
    }
}
