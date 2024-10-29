package pre2_1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class T1_4 {

    public int solution(String s) {
        Set<String> strSet = new HashSet<>();
        Collections.addAll(strSet, s.split(" "));
        return strSet.size();
    }

    public static void main(String[] args) {
        T1_4 t = new T1_4();
        System.out.println(t.solution(
                "Hello world Nice world")); // 3
    }
}
