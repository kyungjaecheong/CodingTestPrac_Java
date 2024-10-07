/*
 * 콘솔 화면에 구구단 출력하기<br>
 * - 다중 반복문을 이용하여 코딩
 * - 콘솔화면에 내용이 맞도록 format함수 이용하여 코딩
 * - 제목 및 1단부터 9단까지 표시(반드시, 예시와 동일한 레이아웃으로 작성)
 */

/**
 * ZeroBase BackEnd School<br>
 * Java 미니과제 1번 - 구구단
 * @author 정경재 (30기)
 */
public class M1W2Ex01 {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");
        for (int r = 1; r <= 9; r++) {
            for (int c = 1; c <= 9; c++) {
                String block = String.format(
                        "%02d x %02d = %02d",
                        c, r, c*r);
                System.out.print(block);
                if (c != 9) {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
