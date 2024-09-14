package codingtest6;

import java.util.Scanner;

/**
 * codingtest6.PrgmTest06_1
 * 6-1. 기초 문제 - a와 b 출력하기
 * ---
 * 정수 a와 b가 주어집니다.
 * 각 수를 입력받아 입출력 예와 같은 형식으로 출력하는 코드를 작성해 보세요.
 */
public class PrgmTest06_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 코드 작성
        /* 비활성화
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        */
        System.out.printf("a = %d\nb = %d\n", a, b);
    }
}
