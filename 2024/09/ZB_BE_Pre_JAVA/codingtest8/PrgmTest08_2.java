package codingtest8;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution08_2 {
    public int[] solution(int[] num_list) {
        int numListLen = num_list.length;
        int last_num = num_list[numListLen-1];
        int prev_num = num_list[numListLen-2];
        int add_num;
        if ( last_num > prev_num ) {
            add_num = last_num - prev_num;
        } else {
            add_num = last_num * 2;
        }
        int[] answer = new int[numListLen+1];
        System.arraycopy(
                num_list, 0,
                answer, 0,
                numListLen);
        answer[numListLen] = add_num;
        return answer;
    }
}

class Solution08_2$2 {
    public int[] solution(int[] num_list) {
        int numListLen = num_list.length;
        int last_num = num_list[numListLen-1];
        int prev_num = num_list[numListLen-2];

        // add_num 계산 (삼항연산자)
        int add_num = (last_num > prev_num)
                ? (last_num - prev_num)
                : (last_num * 2);

        // IntStream 활용
        return IntStream.concat(
                IntStream.of(num_list), // 기본 배열 스트림
                IntStream.of(add_num)   // 새로운 값 스트림
        ).toArray(); // int[] 배열로 변환
    }
}

/**
 * codingtest8.PrgmTest08_2
 * 8-2. 기초 문제 - 마지막 두 원소
 * ---
 * 정수 리스트 num_list가 주어질 때,
 * 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을
 * 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여
 * return하도록 solution 함수를 완성해주세요.
 */
public class PrgmTest08_2 {

    private static final int[] numList1 = {2, 1, 6};
    private static final int[] numList2 = {5, 2, 1, 7, 5};
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(Arrays.toString(new Solution08_2().solution(numList1)));
        System.out.println(Arrays.toString(new Solution08_2().solution(numList2)));

        System.out.println("=".repeat(50));

        System.out.println(Arrays.toString(new Solution08_2$2().solution(numList1)));
        System.out.println(Arrays.toString(new Solution08_2$2().solution(numList2)));

    }
}
