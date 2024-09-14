package codingtest5;

import java.util.Arrays;

class Solution05_1 {
    public int[] solution(int[] num_list) {
        int[] SortedArr = Arrays.copyOf(num_list, num_list.length);
        Arrays.sort(SortedArr);

        int[] answer = new int[5];
        System.arraycopy(SortedArr, 0, answer, 0, 5);

        return answer;
    }
}

class Solution05_1$2 {
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.stream(num_list)
                .sorted().limit(5).toArray();

        return answer;
    }
}

/**
 * codingtest5.PrgmTest05_1
 * 5-1. 기초 문제 - 뒤에서 5등까지
 * ---
 * 정수로 이루어진 리스트 num_list가 주어집니다.
 * num_list에서 가장 작은 5개의 수를 오름차순으로 담은 리스트를
 * return하도록 solution 함수를 완성해주세요.
 */
public class PrgmTest05_1 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        int[] testArr = {12, 4, 15, 46, 38, 1, 14};

        System.out.println(Arrays.toString(new Solution05_1().solution(testArr)));

        System.out.println("=".repeat(50));

        System.out.println(Arrays.toString(new Solution05_1$2().solution(testArr)));
    }
}
