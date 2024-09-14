package codingtest14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution14_2 {
    public int solution(int[] rank, boolean[] attendance) {
        // TreeMap은 기본적으로 오름차순 (0 ..... n) - Comparator를 반대로 주면 내림차순
        Map<Integer, Integer> rankMap = new TreeMap<>();
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                rankMap.put(rank[i], i);
            }
        }

        List<Integer> top3 = new ArrayList<>();

        for (Integer key : rankMap.keySet()) {
            if (top3.size() >= 3) break;
            top3.add(rankMap.get(key));
        }

        int answer = 0;

        for (int i = 0; i < 3; i++) {
            answer += top3.get(i) * (int) Math.pow(100, (2 - i));
        }

        return answer;
    }
}

/**
 * 14-2. 기초 문제 - 전국 대회 선발 고사
 * ---
 * 0번부터 n - 1번까지 n명의 학생 중 3명을 선발하는 전국 대회 선발 고사를 보았습니다.
 * 등수가 높은 3명을 선발해야 하지만, 개인 사정으로 전국 대회에 참여하지 못하는 학생들이 있어
 * 참여가 가능한 학생 중 등수가 높은 3명을 선발하기로 했습니다.
 * 각 학생들의 선발 고사 등수를 담은 정수 배열 rank와 전국 대회 참여 가능 여부가 담긴
 * boolean 배열 attendance가 매개변수로 주어집니다.
 * 전국 대회에 선발된 학생 번호들을 등수가 높은 순서대로 각각 a, b, c번이라고 할 때
 * 10000 × a + 100 × b + c를 return 하는 solution 함수를 작성해 주세요.
 */
public class PrgmTest14_2 {
    public static final int[] rank1 = {3, 7, 2, 5, 4, 6, 1};
    public static final boolean[] attendance1 = {false, true, true, true, true, false, false};
    public static final int[] rank2 = {1, 2, 3};
    public static final boolean[] attendance2 = {true, true, true};
    public static final int[] rank3 = {6, 1, 5, 2, 3, 4};
    public static final boolean[] attendance3 = {true, false, true, false, false, true};

    public static void main(String[] args) {
        System.out.println("=".repeat(50));

        System.out.println(new Solution14_2().solution(rank1, attendance1));
        System.out.println(new Solution14_2().solution(rank2, attendance2));
        System.out.println(new Solution14_2().solution(rank3, attendance3));
    }
}
