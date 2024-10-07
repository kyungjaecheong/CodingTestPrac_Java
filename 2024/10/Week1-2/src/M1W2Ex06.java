import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * 가상 선거 및 당선 시뮬레이션 프로그램
 * - 조건문 및 반복문과 배열(or 컬렉션)을 통한 당선 시뮬레이션 로직 작성
 * - 선거를 미리 시뮬레이션을 통해서 진행하는 프로그램
 *   - 전체 투표수와 후보자를 입력받아서 그 결과를 미리 확인하는
 *     선거 및 당선 시뮬레이션 프로그램
 * - 필수 조건
 *   - 총 투표를 진행할 투표수를 입력 받음
 *   - 선거를 진행할 후보자 수를 입력 받고, 이에 대한 이름을 입력 받음
 *   - 각 입력받은 후보자는 순서대로 기호1, 기호2, 기호3… 형식으로 기호번호 부여
 *   - 각 투표수의 결과는 선거를 진행할 후보자를 동일한 비율로 랜덤하게 발생
 *   - 임의번호는 Random함수의 nextInt()함수를 통해서 생성
 *   - 1표에 대한 투표한 결과에 대해서 투표자와 이에 대한 결과를 화면 출력
 * - 전제 조건
 *   - 투표수는 1 ~ 10000 사이의 값을 입력하며, 그외 값 입력에 대한 예외는 없다고 가정
 *   - 후보자 인원은 2 ~ 10 사이의 값을 입력받으면, 그외 값 입력에 대한 예외는 없다고 가정
 *   - 후보자이름은 한글로 입력하며, 10자 미만으로 입력함. (역시, 그외 입력에 대한 예외는 없다)
 */
public class M1W2Ex06 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("[가상 선거 시뮬레이션 프로그램]");

            int population = getPopulation(sc);
            Map<Integer, String> candidateMap = getCandidateMap(sc);

            showVoting(population, candidateMap);

        } catch (Exception e) {
            System.out.println("[Exception 발생] : " + e);
        } finally {
            System.out.println("\n프로그램을 종료합니다.");
        }
    }

    private static void showVoting(
            int population,
            Map<Integer, String> candidateMap
    ) {
        Random random = new Random();
        Map<Integer, Integer> votesMap = new LinkedHashMap<>();
        int candidates = candidateMap.size();
        for (int i = 1; i <= candidates; i++) {
            votesMap.put(i, 0);
        }

        for (int p = 1; p <= population; p++) {
            int vote = random.nextInt(candidates) + 1;

            votesMap.put(vote, votesMap.get(vote) + 1);

            double totalRatio = (double) p / population * 100;
            System.out.printf("\n[투표진행률]: %.2f%%, %d명투표 => %s\n",
                    totalRatio, p, candidateMap.get(vote));
            for (int i = 1; i <= candidates; i++) {
                String name = candidateMap.get(i);
                int candiVotes = votesMap.get(i);
                double candiRatio = (double) candiVotes / population * 100;
                System.out.printf("[기호:%d] %s:\t%3.2f%%\t(투표수: %d)\n",
                        i, name, candiRatio, candiVotes);
            }
        }
        int resultIdx = 0;
        int resultVotes = 0;
        for (Map.Entry<Integer, Integer> entry : votesMap.entrySet()) {
            Integer key = entry.getKey();
            Integer votes = entry.getValue();
            if (votes > resultVotes) {
                resultIdx = key;
                resultVotes = votes;
            }
        }
        System.out.println("\n[투표결과] 당선인 : " + candidateMap.get(resultIdx));
    }

    private static int getPopulation(Scanner sc) {
        while (true) {
            System.out.print("총 진행할 투표수를 입력해 주세요. : ");
            String input = sc.nextLine();
            if (input.matches("^[0-9]{1,5}$")) {
                int value = Integer.parseInt(input);
                if (value >= 1 && value <= 10000) {
                    return value;
                }
            }
            System.out.println("[입력 오류] 총 투표수는 1 ~ 10000 사이로 입력해 주세요.");
        }
    }

    private static Map<Integer, String> getCandidateMap(Scanner sc) {
        Map<Integer, String> candidateMap = new LinkedHashMap<>();
        while (true) {
            System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요. : ");
            String candiInput = sc.nextLine();
            if (candiInput.matches("^[0-9]{1,2}$")) {
                int candidates = Integer.parseInt(candiInput);
                if (candidates >= 2 && candidates <= 10) {
                    addCandidates(sc, candidateMap, candidates);
                    break;
                } else {
                    System.out.println("[입력 오류] 후보자 인원은 2 ~ 10명 사이로 입력해 주세요.");
                }
            } else {
                System.out.println("[입력 오류] 숫자를 입력해 주세요. (2 ~ 10)");
            }
        }
        return candidateMap;
    }

    private static void addCandidates(
            Scanner sc,
            Map<Integer, String> candidateMap,
            int candidates) {
        for (int i = 1; i <= candidates; i++) {
            while (true) {
                System.out.printf("%d번째 후보자 이름을 입력해 주세요. : ", i);
                String name = sc.nextLine();

                if (name.matches("^[가-힣]{1,9}$")) {
                    candidateMap.put(i, name);
                    break;
                } else {
                    System.out.println("[입력 오류] 후보자의 이름은 10자 미만의 한글로 입력해 주세요.");
                }
            }

        }
    }
}
