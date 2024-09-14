package codingtest9;

import java.util.Arrays;

class Solution09_2 {
    public int[] solution(int[] arr, int[][] queries) {

        for (int[] queryArr : queries) {
            for (int i = queryArr[0]; i <= queryArr[1]; i++) {
                if (i % queryArr[2] == 0) {
                    arr[i] += 1;
                }
            }
        }

        int[] answer = arr;
        return answer;
    }
}

/**
 * codingtest9.PrgmTest09_2
 * 9-2. 기초 문제 - 수열과 구간 쿼리 4
 * ---
 * 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다.
 * queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다. *
 * 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 i가 k의 배수이면 arr[i]에 1을 더합니다. *
 * 위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
 */
public class PrgmTest09_2 {
    private static final int[] testarr1 = {0, 1, 2, 4, 3};
    private static final int[][] testqueries1 = {{0,4,1},{0,3,2},{0,3,3}};
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(Arrays.toString(new Solution09_2().solution(testarr1, testqueries1)));

    }
}
