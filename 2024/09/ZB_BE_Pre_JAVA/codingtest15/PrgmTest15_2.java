package codingtest15;

import java.time.LocalDate;

class Solution15_2 {
    public int solution(int[] date1, int[] date2) {
        LocalDate ldt1 = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate ldt2 = LocalDate.of(date2[0], date2[1], date2[2]);

        int answer = (ldt1.isBefore(ldt2)) ? 1 : 0;
        return answer;
    }
}

/**
 * 15-2. 기초 문제 - 날짜 비교하기
 * ---
 * 정수 배열 date1과 date2가 주어집니다.
 * 두 배열은 각각 날짜를 나타내며 [year, month, day] 꼴로 주어집니다.
 * 각 배열에서 year는 연도를, month는 월을, day는 날짜를 나타냅니다.
 * 만약 date1이 date2보다 앞서는 날짜라면 1을, 아니면 0을
 * return 하는 solution 함수를 완성해 주세요.
 */
public class PrgmTest15_2 {
    public static final int[][] testArr1 = {{2021, 12, 28},{2021, 12, 29}};
    public static final int[][] testArr2 = {{1024, 10, 24},{1024, 10, 24}};

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(new Solution15_2().solution(testArr1[0], testArr1[1]));
        System.out.println(new Solution15_2().solution(testArr2[0], testArr2[1]));
    }
}
