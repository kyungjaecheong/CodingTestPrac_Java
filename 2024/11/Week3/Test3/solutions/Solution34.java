import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution34 {
    public int solution (int x1, int y1, int x2, int y2) {
        Set<List<Integer>> setA = new HashSet<>();
        Set<List<Integer>> setB = new HashSet<>();
        setA.add(List.of(x1, y1));
        setB.add(List.of(x2, y2));

        Set<List<Integer>> histA = new HashSet<>(Set.copyOf(setA));
        Set<List<Integer>> histB = new HashSet<>(Set.copyOf(setB));

        if (x1 == x2 && y1 == y2) {
            return 0;
        }

        int time = 1;
        while (true) {
            Set<List<Integer>> newSetA = new HashSet<>();
            Set<List<Integer>> newSetB = new HashSet<>();

            setA.forEach(posA -> {
                newSetA.add(List.of(posA.get(0) + 1, posA.get(1)));
                newSetA.add(List.of(posA.get(0), posA.get(1) + 1));
                newSetA.add(List.of(posA.get(0) - 1, posA.get(1)));
                newSetA.add(List.of(posA.get(0), posA.get(1) - 1));
            });
            setB.forEach(posB -> {
                newSetB.add(List.of(posB.get(0) + 1, posB.get(1) + 1));
                newSetB.add(List.of(posB.get(0) + 1, posB.get(1) - 1));
                newSetB.add(List.of(posB.get(0) - 1, posB.get(1) + 1));
                newSetB.add(List.of(posB.get(0) - 1, posB.get(1) - 1));
            });

            newSetA.removeAll(histA);
            newSetB.removeAll(histB);

            for (List<Integer> posA: newSetA) {
                if (newSetB.contains(posA)) {
                    return time;
                }
            }

            histA.addAll(newSetA);
            histB.addAll(newSetB);

            setA = newSetA;
            setB = newSetB;
            time++;
        }
    }
}