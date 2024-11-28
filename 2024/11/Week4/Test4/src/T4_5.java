import java.util.*;

public class T4_5 {
    public int[][] solution(int[][] buildings) {
        List<int[]> result = new ArrayList<>(); // 결과 저장용 리스트
        List<int[]> points = new ArrayList<>(); // 건물의 시작/끝 점 저장

        for (int[] building : buildings) {
            points.add(new int[]{building[0], building[2]}); // 시작점
            points.add(new int[]{building[1], -building[2]}); // 끝점
        }

        // 점들을 x 좌표 기준으로 정렬 (같은 x일 경우 높이 우선 정렬)
        points.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 현재 높이 저장
        maxHeap.add(0); // 초기값 0 (지면)

        int prevMaxHeight = 0; // 이전 최대 높이

        for (int[] point : points) {
            int x = point[0];
            int height = point[1];

            if (height > 0) {
                maxHeap.add(height); // 시작점이면 높이 추가
            } else {
                maxHeap.remove(-height); // 끝점이면 높이 제거
            }

            int currentMaxHeight = maxHeap.peek(); // 현재 최대 높이

            if (currentMaxHeight != prevMaxHeight) { // 높이가 변하면 결과에 추가
                result.add(new int[]{x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result.toArray(new int[result.size()][]); // 리스트를 배열로 변환
    }

    public static void main(String[] args) {
        T4_5 t = new T4_5();
        int[][] buildings = new int[][]{
                {1, 8, 4},
                {2, 4, 10},
                {3, 5, 6},
                {10, 12, 6}
        };

        int[][] result = t.solution(buildings);

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }

        // {1,4}, {2,10}, {4,6}, {5,4}, {8,0}, {10,6}, {12,0}
    }
}
