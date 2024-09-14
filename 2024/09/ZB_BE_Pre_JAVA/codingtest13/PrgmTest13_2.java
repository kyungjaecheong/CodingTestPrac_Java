package codingtest13;

class Solution13_2 {
    public int solution(int[] numbers, int n) {
        int answer = 0;

        int idx = 0;
        do {
            answer += numbers[idx++];
        } while (answer <= n);

        return answer;
    }
}

/**
 * 13-2. 기초 문제 - n보다 커질 때까지 더하기
 * ---
 * 정수 배열 numbers와 정수 n이 매개변수로 주어집니다.
 * numbers의 원소를 앞에서부터 하나씩 더하다가 그 합이 n보다 커지는 순간
 * 이때까지 더했던 원소들의 합을
 * return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest13_2 {
    public static final int[] testArr1 = {34, 5, 71, 29, 100, 34};
    public static final int[] testArr2 = {58, 44, 27, 10, 100};

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(new Solution13_2().solution(testArr1, 123));
        System.out.println(new Solution13_2().solution(testArr2, 139));
    }
}
