package pre2_5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T5_3 {

    public int solution(int[] cards) {
        if (cards.length == 0) return 0;
        PriorityQueue<Integer> cardPQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int card : cards) cardPQ.offer(card);

        while (!cardPQ.isEmpty()) {
            int pick1 = cardPQ.poll();
            if (cardPQ.isEmpty()) return pick1;

            int pick2 = cardPQ.poll();
            if (pick1 != pick2) {
                int remainLife = Math.abs(pick1 - pick2);
                cardPQ.offer(remainLife);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        T5_3 t = new T5_3();
        System.out.println(t.solution(new int[]{4, 8, 6, 1, 2})); // 1
    }
}
