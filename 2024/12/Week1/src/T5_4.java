public class T5_4 {

    public int solution(int N, int[] branches) {
        int low = 1; // 교보재 최소 길이

        int high = 0; // 교보재 최대 길이
        for (int branch : branches) {
            high = Math.max(high, branch); // 최대 길이 갱신
        }

        int result = -1; // 결과값 (-1은 불가능을 의미)

        while (low <= high) {
            int mid = (low + high) / 2; // 중간 길이

            // 중간 길이로 교보재를 만들 때 필요한 개수 계산
            int count = 0;
            for (int branch : branches) {
                count += branch / mid; // 중간 길이로 나눈 몫을 더함
            }

            // 필요한 개수가 N보다 크거나 같은 경우
            if (count >= N) {
                result = mid; // 결과값 갱신
                low = mid + 1; // 더 큰 길이 탐색
            } else {
                high = mid - 1; // 더 작은 길이 탐색
            }
        }

        return result;
    }

    public static void main(String[] args) {
        T5_4 t = new T5_4();
        int N = 10;
        int[] branches = {6, 7, 10, 16, 12};
        System.out.println(t.solution(N, branches)); // 4
    }
}
