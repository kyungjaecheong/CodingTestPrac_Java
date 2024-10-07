import java.time.LocalDate;
import java.util.Scanner;

/*
 *  Scanner의 입력함수와 조건문 및 반복문을 통한 달력 계산 로직 작성
 *  - 입력받은 년도와 월을 통한 달력 생성
 *  - 입력값은 년도, 월을 입력
 *  - 날짜는 LocalDate클래스를 이용(Calendar와 Date클래스도 이용 가능)
 *  - 출력은 입력한 달을 기준으로 이전달, 입력달, 현재달 출력(3달 출력)
 */

/**
 * ZeroBase BackEnd School<br>
 * Java 미니과제 5번 - 달력 출력 프로그램
 * @author 정경재 (30기)
 */
public class M1W2Ex05 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n[달력 출력 프로그램]");
                int year = getYearInput(sc);
                int month = getMonthInput(sc);

                printThreeMonths(year, month);

                System.out.print("\n다시 생성 하려면 'y'를 입력해 주세요. ('y' 이외엔 종료) : ");
                String again = sc.nextLine();
                if (!again.equalsIgnoreCase("y")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("[Exception 발생] : " + e);
        } finally {
            System.out.println("프로그램을 종료 합니다.");
        }
    }

    private static int getYearInput(Scanner sc) {
        while (true) {
            System.out.print("달력의 년도를 입력해 주세요.(yyyy) : ");
            String yearInput = sc.nextLine();
            if (yearInput.matches("^[0-9]{4}$")) {
                int year = Integer.parseInt(yearInput);
                if (year >= 1000 + 1 && year <= 9999 - 1) {
                    return year;
                }
            }
            // 3개 달을 출력하기 위한 조건 검사
            System.out.println("[입력 오류] 달력 년도는 1001 ~ 9998 사이로 입력해 주세요.");
        }
    }

    private static int getMonthInput(Scanner sc) {
        while (true) {
            System.out.print("달력의 월을 입력해 주세요.(mm) : ");
            String monthInput = sc.nextLine();
            if (monthInput.matches("^[0-9]{1,2}$")) {
                int month = Integer.parseInt(monthInput);
                if (month >= 1 && month <= 12) {
                    return month;
                }
            }
            System.out.println("[입력 오류] 달력 월은 1 ~ 12 사이로 입력해 주세요.");
        }
    }

    private static void printThreeMonths(int year, int month) {
        LocalDate currMonth = LocalDate.of(year, month, 1);
        LocalDate prevMonth = currMonth.minusMonths(1);
        LocalDate nextMonth = currMonth.plusMonths(1);
        LocalDate[] months = {prevMonth, currMonth, nextMonth};

        for (int i = 0; i < months.length; i++) {
            System.out.printf("[%d년 %02d월]",
                    months[i].getYear(), months[i].getMonthValue());
            if (i < months.length - 1) {
                System.out.print("\t\t\t\t\t");
            }
        }
        System.out.println();

        String[] daysOfWeek = {"일", "월", "화", "수", "목", "금", "토"};
        for (int i = 0; i < months.length; i++) {
            for (String day : daysOfWeek) {
                System.out.printf("%s\t",day);
            }
            if (i < months.length - 1) {
                System.out.print("\t");
            }
        }
        System.out.println();

        for (int week = 0; week < 6; week++) { //최대 6주
            for (int m = 0; m < months.length; m++) {
                LocalDate firstDay = months[m];

                int emptyDays = firstDay.getDayOfWeek().getValue() % 7; // 일요일은 0
                int daysInMonth = firstDay.lengthOfMonth();

                for (int dayInWeek = 0; dayInWeek < 7; dayInWeek++) {
                    int day = week * 7 + dayInWeek - emptyDays + 1;
                    if (day <= 0 || day > daysInMonth)  {
                        System.out.print("\t");
                    } else {
                        System.out.printf("%02d\t", day);
                    }
                }
                if (m < months.length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
