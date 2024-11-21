import java.util.*;

public class CT3_5 {

    public int solution(int[] reward, int[] health, int[] optional) {
        int n = reward.length;
        int attackPower = 1;
        int totalTime = 0;

        for (int i = 0; i < n; i++) {
            if (optional[i] == 1) {
                int nextAttackPower = attackPower;
                int skipTime = 0;
                for (int j = i + 1; j < n; j++) {
                    skipTime += (int) Math.ceil((double) health[j] / nextAttackPower);
                    nextAttackPower += reward[j];
                }

                int timeToDefeat = (int) Math.ceil((double) health[i] / attackPower);
                int defeatTime = timeToDefeat;
                nextAttackPower = attackPower + reward[i];
                for (int j = i + 1; j < n; j++) {
                    defeatTime += (int) Math.ceil((double) health[j] / nextAttackPower);
                    nextAttackPower += reward[j];
                }

                if (defeatTime > skipTime) {
                    continue;
                }
            }

            int timeToDefeat = (int) Math.ceil((double) health[i] / attackPower);
            totalTime += timeToDefeat;
            attackPower += reward[i];
        }

        return totalTime;
    }
    public static void main(String[] args) {
        CT3_5 t = new CT3_5();

        System.out.println(t.solution(
                new int[]{4, 2, 2, 0, 3, 5},
                new int[]{10, 20, 20, 20, 40, 30},
                new int[]{1, 0, 1, 0, 0, 0}
        )); // 26
    }
}
