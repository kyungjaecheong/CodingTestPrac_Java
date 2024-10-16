import java.io.IOException;

/**
 * Day3 - 필수 문제 (Array로 풀것 !)
 * 최소, 최대
 * ---
 * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 * ---
 * 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
 * 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
 * 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
 * ---
 * 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 */
public class OnBoardingDay3_1 {

    public static void main(String[] args) throws IOException {
        int n = getInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = getInt();
        }

        StringBuilder sb = new StringBuilder();

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        sb.append(minVal).append(" ").append(maxVal);
        System.out.println(sb);
    }

    private static int getInt() throws IOException {
        int curInt = 0;
        boolean isMinus = false;
        int cursor;

        while (true) {
            cursor = System.in.read();
            if (cursor == -1
                || cursor == ' '
                || cursor == '\n') break;

            if (cursor == '-') {
                isMinus = true;
            } else {
                curInt *= 10;
                curInt += (cursor - '0');
            }
        }

        return (isMinus) ? -curInt : curInt;
    }

    /* 풀이 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine(); // n은 필요없음
        String[] numsStr = br.readLine().split(" ");
        br.close();

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (String numStr : numsStr) {
            int num = Integer.parseInt(numStr);
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        System.out.println(minVal + " " + maxVal);
    }
     */

    /* 풀이 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nStr = br.readLine();
        String[] numsStr = br.readLine().split(" ");
        br.close();

        int n = Integer.parseInt(nStr);
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        getMinMax(nums, bw);

        bw.flush();
        bw.close();
    }

    public static void getMinMax(int[] arr, BufferedWriter bw) throws IOException {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int num : arr) {
            minVal = Math.min(num, minVal);
            maxVal = Math.max(num, maxVal);
        }

        bw.write(String.format(
                "%d %d\n",
                minVal, maxVal));
    }

     */

    /* test
    public static void main(String[] args) {
        int n = 5;
        int[] testArr = {20, 10, 35, 30, 7}; // 7 35
        testSol(n, testArr);
    }

    public static void testSol(int n, int[] arr) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = 0;

        for (int i : arr) {
            if (i < minVal) {
                minVal = i;
            }
            if (i > maxVal) {
                maxVal = i;
            }
        }

        System.out.println(minVal + " " + maxVal);
    }
     */
}
