public class Test_2_1 {
    public static String solution(int n, String s, int t) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        sb.append(s);

        String displayStr = sb.toString();
        int len = displayStr.length();

        int startIdx = t % len;

        if (startIdx + n <= len) {
            return displayStr.substring(startIdx, startIdx + n);
        } else {
            return displayStr.substring(startIdx)
                    + displayStr.substring(0, (startIdx + n) % len);
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(
                5,
                "Snowball",
                18
        ));
    }
}
