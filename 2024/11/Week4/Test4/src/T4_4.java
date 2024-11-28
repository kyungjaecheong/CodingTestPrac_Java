import java.util.*;

public class T4_4 {
    public int[] solution(int[] start, int[] time) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]
        );

        List<int[]> tasks = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            tasks.add(new int[]{i, start[i], time[i]});
        }

        tasks.sort((a, b) -> a[1] - b[1]);

        int currentTime = 0;
        int i = 0;

        while (i < tasks.size() || !queue.isEmpty()) {
            while (i < tasks.size() && tasks.get(i)[1] <= currentTime) {
                queue.offer(new int[]{tasks.get(i)[0], tasks.get(i)[2], tasks.get(i)[1]});
                i++;
            }

            if (queue.isEmpty()) {
                currentTime = tasks.get(i)[1];
                continue;
            }


            int[] nextTask = queue.poll();
            result.add(nextTask[0]);
            currentTime += nextTask[1];
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        T4_4 t = new T4_4();
        int[] start = new int[]{0, 2, 3, 5, 6};
        int[] time = new int[]{2, 4, 2, 1, 3};

        System.out.println(Arrays.toString(t.solution(start, time)));
        // 0, 1, 3, 2, 4
    }
}
