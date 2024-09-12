package codingtest5;

import java.util.Scanner;

/**
 * codingtest5.PrgmTest05_2
 * 5-2. 기초 문제 - 홀짝 구분하기
 * ---
 * 자연수 n이 입력으로 주어졌을 때
 * 만약 n이 짝수이면 "n is even"을,
 * 홀수이면 "n is odd"를 출력하는 코드를 작성해 보세요.
 */
public class PrgmTest05_2 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        Scanner sc = new Scanner(System.in);
        System.out.print("자연수 입력: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println(n + " is even");
        } else {
            System.out.println(n + " is odd");
        }

    }
}
