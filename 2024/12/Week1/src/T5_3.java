public class T5_3 {

    public int solution(int[] arr) {
        // 배열 길이가 3보다 작으면 피크가 존재할 수 없음
        if (arr.length < 3) {
            return -1;
        }

        int left = 1; // 첫 번째 요소는 피크가 될 수 없음
        int right = arr.length - 2; // 마지막 요소도 피크가 될 수 없음

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 피크 조건을 만족하면 mid 반환
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // 오른쪽으로 이동해야 하는 경우
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            // 왼쪽으로 이동해야 하는 경우
            else {
                right = mid - 1;
            }
        }

        // 피크가 없는 경우 -1 반환
        return -1;
    }

    public static void main(String[] args) {
        T5_3 t = new T5_3();
        int[] arr = {-3, 0, 3, 4, 5, 12, 15, 14, 12, 11};
        System.out.println(t.solution(arr)); // 6
    }
}
