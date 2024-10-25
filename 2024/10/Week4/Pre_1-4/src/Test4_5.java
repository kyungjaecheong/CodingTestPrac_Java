public class Test4_5 {

    public String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Test4_5 t = new Test4_5();
        String[] arr = {"naver", "kakao"};
        System.out.println(t.solution(arr));
    }
}
