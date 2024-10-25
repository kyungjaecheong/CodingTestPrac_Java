public class Test4_2 {

    public int solution(String[] arr) {
        int answer = Integer.parseInt(arr[0], 2);

        for (int i = 1; i < arr.length; i++) {
            int cur = Integer.parseInt(arr[i], 2);
            answer ^= cur;
        }

        return answer;
    }

    public static void main(String[] args) {
        Test4_2 t = new Test4_2();
        String[] arr = {"10110", "1010", "11110"}; // 2
        System.out.println(t.solution(arr));
    }
}
