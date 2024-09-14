package codingtest7;

import java.util.stream.IntStream;

class Solution07_2 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;

        for (int i = 0; i < included.length; i++ ) {
            if (included[i]) {
                answer += a + d * i;
            }
        }

        return answer;
    }
}

class Solution07_2$2 {
    public int solution(int a, int d, boolean[] included) {
        int answer = IntStream.range(0, included.length)
                .map(idx -> included[idx] ? a + d * idx : 0)
                .sum();
        return answer;
    }
}

/**
 * codingtest6.PrgmTest07_2
 * 7-2. 기초 문제 - 등차수열의 특정한 항만 더하기
 * ---
 * 두 정수 a, d와 길이가 n인 boolean 배열 included가 주어집니다.
 * 첫째항이 a, 공차가 d인 등차수열에서 included[i]가 i + 1항을 의미할 때,
 * 이 등차수열의 1항부터 n항까지 included가 true인 항들만 더한 값을
 * return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest07_2 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        int[] testInt1 = {3, 4};
        boolean[] included1 = {true, false, false, true, true};
        int[] testInt2 = {7, 1};
        boolean[] included2 = {false, false, false, true, false, false, false};

        System.out.println(new Solution07_2().solution(testInt1[0], testInt1[1], included1));
        System.out.println(new Solution07_2().solution(testInt2[0], testInt2[1], included2));

        System.out.println("=".repeat(50));

        System.out.println(new Solution07_2$2().solution(testInt1[0], testInt1[1], included1));
        System.out.println(new Solution07_2$2().solution(testInt2[0], testInt2[1], included2));


    }
}
