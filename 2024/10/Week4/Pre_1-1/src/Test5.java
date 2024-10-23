public class Test5 {

    public static int solution(String S) {
        int pInt = Integer.parseInt(S, 2);

        int opCnt = 0;
        while (pInt > 0) {
            if (pInt % 2 == 0) pInt >>= 1;
            else pInt -= 1;
            opCnt++;
        }

        return opCnt;
    }

    public static void main(String[] args) {
        String s = "1101";
        System.out.println(solution(s));

    }
}
