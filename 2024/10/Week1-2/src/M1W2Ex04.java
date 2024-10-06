import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

/**
 * 주민등록번호 생성 프로그램
 * - Scanner의 입력함수와 조건문 및 Random클래스를 통한 주민번호 생성 로직 작성
 *    - 2020년도 부터 생성 조건이 변경되었습니다. (지역번호, 등록순서, 검증번호 -> 임의번호)
 *    - 조건에 맞게 생성하는 프로그램을 작성해 보세요
 *    - 입력값은 2020년도 이후로 입력한다는 전제로 작성
 * - 조건
 *   - 주민등록번호 생성 로직에 맞게 주민등록번호 생성
 *   - 입력값은 생년, 월, 일, 성별과 임의의 번호를 통해서 생성
 *   - 임의번호는 Random함수의 nextInt()함수를 통해서 생성
 *     (임의 번호 범위는 1 ~ 999999사이의 값으로 설정)
 */
public class M1W2Ex04 {
    public static void main(String[] args) {
        Random random = new Random();   // seed는 지정하지 않음

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n[주민등록번호 생성]");

                int year = getYearInput(sc);
                int month = getMonthInput(sc);
                int date = getDayInput(sc, year, month);

                String frontId = makeFrontId(year, month, date);
                if (frontId == null) { // date 입력 오류는 메서드에서 캐치
                    continue;
                }

                String genderInput = getGenderInput(sc);
                int genderCode = (genderInput.equals("m")) ? 3 : 4;

                int randomCode = random.nextInt(999999) + 1;
                String backId = String.format("%06d", randomCode);

                System.out.println(frontId + "-" + genderCode + backId);

                System.out.print("\n다시 하려면 'y'를 입력해 주세요. ('y' 이외엔 종료) : ");
                String again = sc.nextLine();
                if (!again.equals("y")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("[Exception 발생] : " + e);
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }

    private static int getYearInput(Scanner sc) {
        while (true) {
            System.out.print("출생 년도를 입력해 주세요. (yyyy) : ");
            String yearInput = sc.nextLine();
            if (yearInput.matches("^[0-9]{4}$")) {
                int year = Integer.parseInt(yearInput);
                if (year >= 2020 && year <= 2099) {
                    return year;
                }
            }
            System.out.println("[입력 오류] 출생 년도는 2020 ~ 2099 (4글자) 사이로 입력해 주세요.");
        }
    }

    private static int getMonthInput(Scanner sc) {
        while (true) {
            System.out.print("출생 월을 입력해 주세요. (mm) : ");
            String monthInput = sc.nextLine();
            if (monthInput.matches("^[0-9]{1,2}$")) {
                int month = Integer.parseInt(monthInput);
                if (month >= 1 && month <= 12) {
                    return month;
                }
            }
            System.out.println("[입력 오류] 출생 월은 1 ~ 12 사이로 입력해 주세요.");
        }
    }

    private static int getDayInput(Scanner sc, int year, int month) {
        while (true) {
            System.out.print("출생 일을 입력해 주세요. (dd) : ");
            String dateInput = sc.nextLine();
            if (dateInput.matches("^[0-9]{1,2}$")) {
                int day = Integer.parseInt(dateInput);
                try {   // 날짜 유효성 검증
                    LocalDate ld = LocalDate.of(year, month, day);
                    return day;
                } catch (RuntimeException e) {
                    System.out.println("[입력 오류] 잘못된 날짜 입니다.");
                }
            } else {
                System.out.println("[입력 오류] 출생 일은 1 ~ 31 사이로 입력해 주세요.");
            }
        }
    }

    private static String getGenderInput(Scanner sc) {
        while (true) {
            System.out.print("성별을 입력해 주세요. (m/f) : ");
            String genderInput = sc.nextLine();
            if (genderInput.matches("^[m|f]$")) {
                return genderInput;
            }
            System.out.println("[입력 오류] 성별은 'm'(남성) 또는 'f'(여성) 으로 입력해 주세요.");
        }
    }

    private static String makeFrontId(int year, int month, int date) {
        try {
            LocalDate ld = LocalDate.of(year, month, date);
            return String.valueOf(year).substring(2) +
                    String.format("%02d", month) +
                    String.format("%02d", date);
        } catch (RuntimeException e) {
            System.out.println("[입력 오류] 잘못된 날짜 입니다. 다시 입력해 주세요.");
            return null;
        }
    }
}
