import java.util.*;

/**
 * 로또 당첨 프로그램
 * - Scanner의 입력함수와 조건문 및 반복문과 배열을 통한 로또 당첨 로직 작성
 *   - 로또는 1-45개의 숫자 사이의 값중 6개를 맞추면 당첨되는 복권
 *   - 로또의 개수를 구매하고(구매수량 입력), 당첨번호를 생성
 *   - 이후, 구매한 로또의 당첨번호를 판단하는 프로그램
 * - 필수 준수 사항
 *   - 로또 구매 수량 입력
 *   - 입력한 개수만큼의 로또 개수 생성
 *   - 로또 당첨 번호 생성(숫자값은 중복 배제 및 정렬해서 표시)
 *   - 당첨 번호와 구매 로또 비교하여 숫자 일치 여부 판단
 *   - Collections.shuffle 함수 사용 금지!
 */
public class M1W2Ex07 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n[로또 당첨 프로그램]\n");

                int lottoNums = getLottoNums(sc);
                Map<Character, Set<Integer>> userlottoMap = getUserLottoMap(lottoNums);
                printUserLotto(userlottoMap);

                Set<Integer> winningNumbers = getWinningNumber();
                printWinningNums(winningNumbers);

                printLottoResults(userlottoMap, winningNumbers);

                System.out.print("\n다시 하려면 'y' 또는 'Y'를 입력해 주세요. ('y' 이외엔 종료) : ");
                String again = sc.nextLine();
                if (!again.equalsIgnoreCase("y")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("[Exception 발생] : " + e);
        } finally {
            System.out.println("\n프로그램을 종료합니다.");
        }
    }

    private static void printLottoResults(
            Map<Character, Set<Integer>> userLotto,
            Set<Integer> winningNums
    ) {
        System.out.println("[내 로또 결과]");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Set<Integer>> entry : userLotto.entrySet()) {
            Character key = entry.getKey();
            Set<Integer> set = entry.getValue();
            int matchNums = numberMatches(set, winningNums);

            sb.append(String.format("%s\t", key));
            for (Integer i : set) {
                sb.append(String.format("%02d,", i));
            }
            sb.deleteCharAt(sb.length()-1)
                    .append(" => ")
                    .append(matchNums)
                    .append("개 일치\n");
        }
        System.out.println(sb);
    }

    private static int numberMatches(Set<Integer> user, Set<Integer> winning) {
        Set<Integer> intersection = new TreeSet<>(user);
        intersection.retainAll(winning);
        return intersection.size();
    }

    private static void printWinningNums(Set<Integer> winningNums) {
        System.out.println("[로또 발표]");
        StringBuilder sb = new StringBuilder().append("\t");
        for (Integer num : winningNums) {
            sb.append(String.format("%02d,", num));
        }
        sb.deleteCharAt(sb.length()-1).append("\n");
        System.out.println(sb);
    }

    private static Set<Integer> getWinningNumber() {
        Set<Integer> winningNums = new TreeSet<>();
        Random random = new Random();
        while (winningNums.size() < 6) {
            int randInt = random.nextInt(45)+1;
            winningNums.add(randInt);
        }
        return winningNums;
    }

    private static void printUserLotto(Map<Character, Set<Integer>> lottoMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Set<Integer>> entry : lottoMap.entrySet()) {
            Character key = entry.getKey();
            Set<Integer> set = entry.getValue();
            sb.append(String.format("%s\t", key));
            for (Integer i : set) {
                sb.append(String.format("%02d,", i));
            }
            sb.deleteCharAt(sb.length()-1).append("\n");
        }
        System.out.println(sb);
    }

    private static Map<Character, Set<Integer>> getUserLottoMap(int lottoNums) {
        Map<Character, Set<Integer>> lottoMap = new TreeMap<>();
        Random random = new Random();
        char baseChar = 'A';
        for (int i = 0; i < lottoNums; i++) {
            char currChar = (char)(baseChar + i);
            lottoMap.put(currChar, new TreeSet<>());
            while (lottoMap.get(currChar).size() < 6) {
                int randInt = random.nextInt(45) + 1;
                lottoMap.get(currChar).add(randInt);
            }
        }
        return lottoMap;
    }

    private static int getLottoNums(Scanner sc) {
        while (true) {
            System.out.print("로또 개수를 입력해 주세요. (숫자 1 ~ 10) : ");
            String input = sc.nextLine();
            if (input.matches("^[0-9]{1,2}$")) {
                int intInput = Integer.parseInt(input);
                if (intInput >= 1 && intInput <= 10) {
                    return intInput;
                }
            }
            System.out.println("[입력 오류] 로또 개수는 1 ~ 10 사이로 입력해 주세요.");
        }
    }
}
