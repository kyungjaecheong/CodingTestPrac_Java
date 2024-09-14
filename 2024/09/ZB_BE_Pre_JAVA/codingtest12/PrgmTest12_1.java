package codingtest12;

import java.util.Arrays;

class Solution12_1 {
    public int[] solution(int[] num_list, int n) {
        int newArrLen = num_list.length - n + 1;
        int[] answer = new int[newArrLen];

        System.arraycopy(
                num_list, n - 1,
                answer, 0,
                newArrLen
        );

        return answer;
    }
}

/**
 * 12-1. 기초 문제 - n 번째 원소부터
 * ---
 * 정수 리스트 num_list와 정수 n이 주어질 때,
 * n 번째 원소부터 마지막 원소까지의 모든 원소를 담은 리스트를
 * return하도록 solution 함수를 완성해주세요.
 */
public class PrgmTest12_1 {
    public static final int[] numList1 = {2,1,6};
    public static final int[] numList2 = {5,2,1,7,5};

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(Arrays.toString(new Solution12_1()
                .solution(numList1, 3)));
        System.out.println(Arrays.toString(new Solution12_1()
                .solution(numList2, 2)));
    }
}
