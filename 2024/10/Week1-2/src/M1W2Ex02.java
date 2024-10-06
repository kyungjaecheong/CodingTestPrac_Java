import java.util.Scanner;

/**
 * 결제 금액 캐시백 계산 프로그램
 * - 수행 목적 : Scanner의 입력함수와 조건문을 통한 캐시백 계산 로직 작성
 *   - 직불카드로 결제를 하게되면 이에 대한 캐시백을 제공
 *   -  주어진 캐시백 금액을 계산하는 프로그램을 작성
 * - 주어진 캐시백 적립 조건에 맞게 캐시백 계산
 *   - 결재 금액의 10%를 적립
 *   - 캐시백포인트 단위는 백원단위
 *   - 한건의 캐시백 포인트는 최대 300원을 넘을 수 없음
 * - 결제 금액을 입력하면, 이에 대한 캐시백 계산 후 결과 출력
 */
public class M1W2Ex02 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input;
            while (true) {
                promptInput();
                input = sc.nextLine();

                // 종료 조건: "exit" 입력
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                // 입력 검증: 숫자가 아닌 경우에만 건너뜀 (음수도 건너뜀)
                if (!input.matches("^[0-9]+$")) {
                    System.out.println("0 이상의 숫자만 입력해 주세요.");
                    continue;
                }

                int intInput = Integer.parseInt(input);
                printResult(intInput);
            }
        } catch (Exception e) {
            System.out.println("Exception 발생 : " + e);
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }

    private static void promptInput() {
        System.out.println("\n[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요. [종료는 exit 입력] (금액) : ");
    }

    private static int calculateCashBack(int input){
        int tenPercent = input / 10; // 결제 금액의 10% 적립
        int cashback = (tenPercent / 100) * 100; // 백원 단위 절사
        return Math.min(cashback, 300); // 최대 캐시백 300원 제한
    }

    private static void printResult(int input){
        int cashBack = calculateCashBack(input);
        System.out.printf(
                "결제 금액은 %d원이고, 캐시백은 %d원 입니다.\n",
                input, cashBack);
    }
}
