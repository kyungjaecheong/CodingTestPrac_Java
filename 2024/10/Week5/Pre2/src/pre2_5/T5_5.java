package pre2_5;

public class T5_5 {

    public String solution(int[] arr) {
        int n = arr.length;

        for (int i = 1; i <= (n - 1) / 2; i++) {
            if (2 * i < n && arr[i] > arr[2 * i]) {
                return "NO";
            }
            if (2 * i + 1 < n && arr[i] > arr[2 * i + 1]) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        T5_5 t = new T5_5();
        int[] arr1 = {0, 5, 10, 15};
        int[] arr2 = {0, 20, 22, 17};
        System.out.println(t.solution(arr1)); // YES
        System.out.println(t.solution(arr2)); // NO
    }
}
