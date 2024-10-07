import java.util.Scanner;

/*
 * 연소득 과세금액 계산 프로그램
 * - Scanner의 입력함수와 조건문 및 반복문 과 배열, 함수를 통한 과세 로직 작성
 *   - 소득에 대한 소득세율표가 있음
 *   - 주어진 표를 기준으로 해서 소득에 대한 세금을 구하는 프로그램을 작성
 */

/**
 * ZeroBase BackEnd School<br>
 * Java 미니과제 8번 - 연소득 과세금액 계산 프로그램
 * @author 정경재 (30기)
 */
public class M1W2Ex08 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                int income = getYearIncome(sc);

                int tax1 = printAndCalculateTax(income);
                int tax2 = calculateTax2(income);

                System.out.printf("[세율에 의한 세금]:\t\t\t%10d\n",tax1);
                System.out.printf("[누진공제 계산에 의한 세금]:\t%10d\n",tax2);

                System.out.print("\n다시 하려면 'y' 또는 'Y'를 입력해 주세요. ('y' 이외엔 종료) : ");
                String again = sc.nextLine();
                if (!again.equalsIgnoreCase("y")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("[Exception 발생] : " + e);
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }

    private static int getYearIncome(Scanner sc) {
        while (true) {
            System.out.print("\n연소득을 입력해 주세요. : ");
            String incomeInput = sc.nextLine();
            if (incomeInput.matches("^[0-9]+$")) {
                int income = Integer.parseInt(incomeInput);
                if (income <= 2_000_000_000) {
                    return income;
                }
            }
            System.out.println("[입력 오류] 연소득은 0 ~ 20억 사이로 입력해 주세요.");
        }
    }

    private enum Tax {
        CASE1(12_000_000,6, 0),
        CASE2(46_000_000,15, 1_080_000),
        CASE3(88_000_000,24, 5_220_000),
        CASE4(150_000_000,35, 14_900_000),
        CASE5(300_000_000,38, 19_400_000),
        CASE6(500_000_000,40, 25_400_000),
        CASE7(1_000_000_000,42, 35_400_000),
        CASE8(2_000_000_000,45, 65_400_000);

        final int limit;
        final int taxRatio;
        final int deduction;

        Tax(int limit, int taxRatio, int deduction) {
            this.limit = limit;
            this.taxRatio = taxRatio;
            this.deduction = deduction;
        }
    }

    private static int printAndCalculateTax(int income) {
        int totalTax = 0;
        int remain =  income;
        int prevLimit = 0;

        StringBuilder sb = new StringBuilder();
        for (Tax t : Tax.values()) {
            if (remain <= 0) break;

            int taxable = Math.min(remain, t.limit - prevLimit);
            int tax = (int) ((long) taxable * t.taxRatio / 100);

            sb.append(String.format("%10d * %2d%% = %10d\n",
                    taxable, t.taxRatio, tax));

            totalTax += tax;
            remain -= taxable;
            prevLimit = t.limit;
        }
        System.out.println(sb);
        return totalTax;
    }

    private static int calculateTax2(int income) {
        Tax taxCase = taxClassification(income);
        int taxRatio = taxCase.taxRatio;
        int taxDeduction = taxCase.deduction;

        return (int) ((long) income * taxRatio / 100) - taxDeduction;
    }
    private static Tax taxClassification(int income) {
        int floorIncome = income / 1_000_000;
        if (floorIncome <= 12) return Tax.CASE1;
        else if (floorIncome <= 46) return Tax.CASE2;
        else if (floorIncome <= 88) return Tax.CASE3;
        else if (floorIncome <= 150) return Tax.CASE4;
        else if (floorIncome <= 300) return Tax.CASE5;
        else if (floorIncome <= 500) return Tax.CASE6;
        else if (floorIncome <= 1000) return Tax.CASE7;
        else return Tax.CASE8;
    }
}
