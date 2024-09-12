package codingtest4;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution04_1 {
    public int[] solution(int[] arr) {

        List<Integer> intList = new ArrayList<>();

        for (int i : arr) {
           List<Integer> temp = new ArrayList<>(Collections.nCopies(i, i));
           intList.addAll(temp);
        }

        int[] answer = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            answer[i] = intList.get(i);
        }
        return answer;
    }
}

/**
 * codingtest4.PrgmTest04_1
 * 4-1. 기초 문제 - 배열의 원소만큼 추가하기
 * ---
 * 아무 원소도 들어있지 않은 빈 배열 X가 있습니다.
 * 양의 정수 배열 arr가 매개변수로 주어질 때,
 * arr의 앞에서부터 차례대로 원소를 보면서
 * 원소가 a라면 X의 맨 뒤에 a를 a번 추가하는 일을 반복한 뒤의 배열 X를
 * return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest04_1 {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        int[] testArr1 = {5,1,4};
        int[] testArr2 = {6,6};
        int[] testArr3 = {1};

        System.out.println(Arrays.toString(new Solution04_1().solution(testArr1)));
        System.out.println(Arrays.toString(new Solution04_1().solution(testArr2)));
        System.out.println(Arrays.toString(new Solution04_1().solution(testArr3)));
    }
}
