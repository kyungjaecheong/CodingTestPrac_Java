public class Sol_2_4 {

    public int solution(int delay, int capacity, int[] times) {
        int currentTime = 0;
        int currentQueue = 0;
        int result = 0;
        for (int time : times) {
            currentTime += time;

            int sent = currentTime / delay;
            currentQueue = Math.max(0, currentQueue - sent);
            if (currentQueue == capacity) {
                result++;
            } else {
                currentQueue++;
            }
            currentTime %= delay;
        }

        return result;
    }

    public static void main(String[] args) {
        Sol_2_4 t = new Sol_2_4();
        System.out.println(t.solution(
                5, 5,
                new int[]{3, 2, 0, 0, 2, 3, 0, 0, 2, 2, 5}
        )); // 3
    }
}
