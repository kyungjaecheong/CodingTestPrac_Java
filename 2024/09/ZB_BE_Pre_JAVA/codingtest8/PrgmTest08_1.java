package codingtest8;

import java.util.HashSet;
import java.util.Set;

class Solution08_1 {
    public int solution(int a, int b, int c) {

        int sum = a + b + c;
        int squareSum = (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        int cubeSum = (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));

        Set<Integer> diceSet = new HashSet<>() {{
            add(a); add(b); add(c);
        }};

        switch (diceSet.size()) {
            case 1 -> {
                return sum * squareSum * cubeSum;
            }
            case 2 -> {
                return sum * squareSum;
            }
            default -> {
                return sum;
            }
        }
    }
}

/**
 * codingtest6.PrgmTest08_1
 * 8-1. 기초 문제 - 주사위 게임 2
 * ---
 * 1부터 6까지 숫자가 적힌 주사위가 세 개 있습니다.
 * 세 주사위를 굴렸을 때 나온 숫자를 각각 a, b, c라고 했을 때 얻는 점수는 다음과 같습니다.
 *   - 세 숫자가 모두 다르다면 a + b + c 점을 얻습니다.
 *   - 세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다르다면
 *     (a + b + c) × (a2 + b2 + c2 )점을 얻습니다.
 *   - 세 숫자가 모두 같다면 (a + b + c) × (a2 + b2 + c2 ) × (a3 + b3 + c3 )점을 얻습니다.
 * 세 정수 a, b, c가 매개변수로 주어질 때, 얻는 점수를
 * return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest08_1 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        int[] testDice1 = {2, 6, 1};
        int[] testDice2 = {5, 3, 3};
        int[] testDice3 = {4, 4, 4};

        System.out.println(new Solution08_1().solution(testDice1[0], testDice1[1], testDice1[2]));
        System.out.println(new Solution08_1().solution(testDice2[0], testDice2[1], testDice2[2]));
        System.out.println(new Solution08_1().solution(testDice3[0], testDice3[1], testDice3[2]));
    }
}
