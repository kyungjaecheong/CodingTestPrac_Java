public class Sol_2_3 {

    int i = 0;

    public String solution(String code) {
        return recursive(code);
    }

    public String recursive(String s) {
        StringBuilder sb = new StringBuilder();
        String temp;

        int num = 0;

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                num = Character.getNumericValue(s.charAt(i));
                i++;
            } else if (s.charAt(i) == '{') {
                i++;
                temp = recursive(s);
                // sb.append(temp.repeat(num)); Java 8 미지원
                for (int j = 0; j < num; j++) {
                    sb.append(temp);
                }
            } else if (s.charAt(i) == '}') {
                i++;
                break;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Sol_2_3 t = new Sol_2_3();
        System.out.println(t.solution(
                "5{he2{l}o}friend"
        )); // hellohellohellohellohellofriend
    }
}
