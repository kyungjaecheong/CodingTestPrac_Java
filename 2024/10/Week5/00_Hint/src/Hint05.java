import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 힌트 5 - 트리
 * ---
 * 루트 없는 트리가 주어진다.
 * 이때, 트리의 루트를 1이라고 정했을 때,
 * 각 노드의 부모를 구하는 프로그램을 작성하시오.
 * ---
 * 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
 * ---
 * 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 */
public class Hint05 {

    public static void main(String[] args) throws IOException{
        int N = getPosInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int from = getPosInt();
            int to = getPosInt();
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int[] parents = new int[N + 1];
        dfs(1, graph, parents);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int node,
                            List<List<Integer>> graph,
                            int[] parent) {
        for (int neighbor : graph.get(node)) {
            if (parent[neighbor] == 0) {
                parent[neighbor] = node;
                dfs(neighbor, graph, parent);
            }
        }
    }

    private static int getPosInt() throws IOException {
        int curInt = 0;
        int cursor;

        while (true) {
            cursor = System.in.read();
            if (cursor == -1 || cursor == '\n' || cursor == ' ') break;

            curInt *= 10;
            curInt += (cursor - '0');
        }
        return curInt;
    }
}
