import java.util.*;

public class CT3_4 {

    static class State {
        int x1, y1, x2, y2, time;

        State(int x1, int y1, int x2, int y2, int time) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.time = time;
        }

        // Generate a unique hash for the state to improve lookup performance
        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            State state = (State) obj;
            return x1 == state.x1 && y1 == state.y1 && x2 == state.x2 && y2 == state.y2;
        }
    }

    public int solution(int x1, int y1, int x2, int y2) {
        // 철수의 이동 방향: 동, 서, 남, 북
        int[] dx1 = {0, 0, -1, 1};
        int[] dy1 = {-1, 1, 0, 0};

        // 영희의 이동 방향: 북서, 북동, 남서, 남동
        int[] dx2 = {-1, -1, 1, 1};
        int[] dy2 = {-1, 1, -1, 1};

        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.time));
        Set<State> visited = new HashSet<>();

        // 초기 상태를 큐에 추가 (좌표를 보정하여 1000을 더함)
        queue.offer(new State(x1 + 1000, y1 + 1000, x2 + 1000, y2 + 1000, 0));
        visited.add(new State(x1 + 1000, y1 + 1000, x2 + 1000, y2 + 1000, 0));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 종료 조건: 두 사람의 거리가 0인 경우 (즉, 서로 만난 경우)
            if (current.x1 == current.x2 && current.y1 == current.y2) {
                return current.time;
            }

            // 철수와 영희 각각 이동을 고려하여 탐색
            for (int i = 0; i < 4; i++) {
                int nx1 = current.x1 + dx1[i];
                int ny1 = current.y1 + dy1[i];

                for (int j = 0; j < 4; j++) {
                    int nx2 = current.x2 + dx2[j];
                    int ny2 = current.y2 + dy2[j];

                    // 다음 상태의 거리 계산
                    int nextDistance = Math.abs(nx1 - nx2) + Math.abs(ny1 - ny2);
                    int currentDistance = Math.abs(current.x1 - current.x2) + Math.abs(current.y1 - current.y2);

                    // 유효한 좌표인지 확인하고, 다음 상태의 거리가 현재 거리보다 줄어든 경우에만 큐에 추가
                    if (isValid(nx1, ny1) && isValid(nx2, ny2) && nextDistance < currentDistance) {
                        State nextState = new State(nx1, ny1, nx2, ny2, current.time + 1);
                        if (!visited.contains(nextState)) {
                            queue.offer(nextState);
                            visited.add(nextState);
                        }
                    }
                }
            }
        }
        return -1; // 목적지에 도달할 수 없는 경우
    }

    // 유효한 좌표인지 확인하는 함수
    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < 2001 && y < 2001;
    }

    // 유효한 좌표인지 확인하는 함수
    public static void main(String[] args) {
        CT3_4 t = new CT3_4();
        System.out.println(t.solution(2,4,5,-3)); // 4
        System.out.println(t.solution(-2,5,4,2)); // 3

    }
}
