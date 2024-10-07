import java.util.Scanner;

/*
 * 놀이동산 입장권 계산 프로그램
 * - 수행 목적 : Scanner의 입력함수와 다중 조건문을 통한 입장권 계산 로직 작성
 * - 놀이공원 입장료를 구하는 조건에 맞게 로직 작성
 *   - 입력내용은 나이, 입장시간, 국가유공자 여부, 복지카드 여부 순으로 입력
 *   - 입장료 할인은 일반 할인과 특별 할인이 있음
 *   - 중복할인 되지 않으며, 중복될 경우 가장 할인을 많이 받은 금액으로
 * - 할인 조건
 *   - 3세미만이면 무료 입장
 *   - 복지카드와 국가유공자의 경우 일반 할인 적용
 *   - 13세미만이면 특별 할인 적용
 *   - 17시이후에 입장하면 특별 할인 적용
 */

/**
 * ZeroBase BackEnd School<br>
 * Java 미니과제 3번 - 놀이동산 입장권 계산 프로그램
 * @author 정경재 (30기)
 */
public class M1W2Ex03 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int age;
            int hour;
            boolean nationalMerit;
            boolean welfareCard;

            while (true) {
                System.out.println("\n[입장권 계산]");

                age = getIntInput(sc,
                        "나이를 입력해 주세요. (숫자) : ",
                        1, 99);
                hour = getIntInput(sc,
                        "입장 시간을 입력해 주세요. (숫자 입력) : ",
                        0, 23);
                nationalMerit = getBooleanInput(sc,
                        "국가 유공자 여부를 입력해 주세요. (y/n) : ");
                welfareCard = getBooleanInput(sc,
                        "복지 카드 여부를 입력해 주세요. (y/n) : ");

                Ticket ticket = getTicketPrice(age, hour, nationalMerit, welfareCard);

                System.out.printf("\n입장료 : %d원\n", ticket.price);

                System.out.print("\n다시 계산 여부를 입력해 주세요. ('y' 이외엔 종료) : ");
                String again = sc.nextLine();
                if (!again.equals("y")) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Exception 발생 : " + e);
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }

    private static int getIntInput(Scanner sc, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            if (input.matches("^[0-9]+$")) {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            }
            System.out.printf("[입력 RangeError] %d ~ %d 까지 입력 가능 합니다.\n\n",
                    min, max);
        }
    }

    private static boolean getBooleanInput(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            if (input.matches("^[y|n]$")) {
                return input.equals("y");
            }
            System.out.println("[입력 Error] y 또는 n 만 입력해 주세요.\n");
        }
    }

    private enum Ticket {
        FREE(0),
        SPECIAL(4000),
        NORMAL(8000),
        BASIC(10000);

        final int price;

        Ticket(int price) {
            this.price = price;
        }
    }

    private static Ticket getTicketPrice(
            int age,
            int hour,
            boolean nationalMerit,
            boolean welfareCard
    ) {
        if (age < 3) {
            return Ticket.FREE;
        }

        if (age < 13 || hour >= 17) {   // 24시(0시) 폐장이라 가정
            return Ticket.SPECIAL;
        }

        if (nationalMerit || welfareCard ) {
            return Ticket.NORMAL;
        }

        return Ticket.BASIC;
    }
}
