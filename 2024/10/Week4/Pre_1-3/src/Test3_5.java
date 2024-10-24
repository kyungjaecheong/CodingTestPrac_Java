import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Test3_5 {

    public String solution(String[] bj, String[] one, String[] two) {
        Set<String> winner = new HashSet<>();
        Collections.addAll(winner, bj);

        int oneCnt = 0;
        for (String o : one) {
            winner.remove(o);
            oneCnt++;
        }

        int twoCnt = 0;
        for (String t : two) {
            winner.remove(t);
            twoCnt++;
        }

        int eatCnt = oneCnt + twoCnt * 2 + 3;
        int reward = eatCnt * 150;

        StringBuilder sb = new StringBuilder().append(reward).append("만원(");
        String win = winner.iterator().next();
        sb.append(win).append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        Test3_5 t = new Test3_5();
        String[] BJ = {"혁준", "하밥", "양상", "심심이", "소스왕"};
        String[] one = {"혁준", "양상"};
        String[] two = {"심심이", "소스왕"};
        System.out.println(t.solution(BJ, one, two));
    }
}
