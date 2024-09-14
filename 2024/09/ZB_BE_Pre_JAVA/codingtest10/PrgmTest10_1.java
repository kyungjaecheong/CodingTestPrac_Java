package codingtest10;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution10_1 {
    public int[] solution(int start_num, int end_num) {
        int[] answer = IntStream.range(start_num, end_num+1)
                .toArray();
        return answer;
    }
}

class Solution10_1$2 {
    public int[] solution(int start_num, int end_num) {
        int arrLen = end_num - start_num + 1;
        int[] answer = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            answer[i] = start_num + i;
        }
        return answer;
    }
}

/**
 * codingtest10.PrgmTest10_1
 * 10-1. 기초 문제 - 카운트 업
 * ---
 * 정수 start_num와 end_num가 주어질 때,
 * start_num부터 end_num까지의 숫자를 차례로 담은 리스트를
 * return하도록 solution 함수를 완성해주세요.
 */
public class PrgmTest10_1 {
    public static final int[] testNums = {3, 10};

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(Arrays.toString(new Solution10_1().solution(testNums[0], testNums[1])));
        System.out.println(Arrays.toString(new Solution10_1$2().solution(testNums[0], testNums[1])));
    }
}
