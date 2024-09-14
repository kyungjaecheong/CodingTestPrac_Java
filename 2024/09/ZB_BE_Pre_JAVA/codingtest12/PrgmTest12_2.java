package codingtest12;

class Solution12_2 {
    public int solution(int[] num_list) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < num_list.length; i++) {
            if ((i - 1) % 2 == 0) {
                sumEven += num_list[i];
            } else {
                sumOdd += num_list[i];
            }
        }

        int answer = Math.max(sumOdd, sumEven);
        return answer;
    }
}

/**
 * 12-2. 기초 문제 - 홀수 vs 짝수
 * ---
 * 정수 리스트 num_list가 주어집니다.
 * 가장 첫 번째 원소를 1번 원소라고 할 때,
 * 홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을
 * return 하도록 solution 함수를 완성해주세요.
 * 두 값이 같을 경우 그 값을 return합니다.
 */
public class PrgmTest12_2 {
    public static final int[] numList1 = {4, 2, 6, 1, 7, 6};
    public static final int[] numList2 = {-1, 2, 5, 6, 3};

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(new Solution12_2().solution(numList1));
        System.out.println(new Solution12_2().solution(numList2));
    }
}
