public class T5_5 {

    public int solution(int N, int M, int[] fry, int[] clean) {
        int low = 0; // 최소 시간
        int high = 100000 * 200; // 최대 시간 (1대 뿐일때 최대 시간)

        int result = -1; // 결과값 (-1은 불가능을 의미)

        // 이진 탐색
        while (low <= high) {
            int mid = low + (high - low) / 2; // 중간 시간

            // mid 시간 동안 M마리 이상의 치킨을 튀길 수 있는지 확인
            if (canCook(mid, N, M, fry, clean)) {
                result = mid; // 결과값 갱신
                high = mid - 1; // 더 작은 시간 탐색
            } else {
                low = mid + 1; // 더 큰 시간 탐색
            }
        }

        return result;
    }

    private boolean canCook(int time, int N, int M, int[] fry, int[] clean) {
        int totalChicken = 0; // 총 치킨 수

        for (int i = 0; i < N; i++) {
            // 한 튀김기가 시간 time동안 몇 마리의 치킨을 튀길 수 있는지 계산
            int cycleTime = fry[i] + clean[i]; // 한 사이클 시간
            int fullCycle = time / cycleTime; // 전체 사이클 횟수
            int remainTime = time % cycleTime; // 남은 시간

            // 전체 사이클 동안 튀긴 치킨 수
            int cookedChicken = fullCycle + (remainTime >= fry[i] ? 1 : 0);
            totalChicken += cookedChicken; // 총 치킨 수 갱신

            if (totalChicken >= M) {
                return true; // M마리 이상 튀겼으면 true 반환
            }
        }

        return totalChicken >= M; // M마리 이상 튀겼으면 true 반환 (M미만이면 false 반환)
    }

    public static void main(String[] args) {
        T5_5 t = new T5_5();
        int N = 2;
        int M = 20;
        int[] fry = {3, 6};
        int[] clean = {2, 1};
        System.out.println(t.solution(N, M, fry, clean)); // 58
    }
}
