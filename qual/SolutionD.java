import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int q = scanner.nextInt();
            Map<Integer, Map<Integer, Long>> graph = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                long w = scanner.nextLong();
                if (!graph.containsKey(u)) {
                    graph.put(u, new HashMap<>());
                }
                if (!graph.containsKey(v)) {
                    graph.put(v, new HashMap<>());
                }
                graph.get(u).put(v, w);
                graph.get(v).put(u, w);
            }
            int[][] query = new int[q][2];
            for (int i = 0; i < q; i++) {
                query[i][0] = scanner.nextInt();
                query[i][1] = scanner.nextInt();
            }
            System.out.printf("Case #%d:%s\n", t + 1, solve(n, m, q, graph, query));
        }
        scanner.close();
    }

    public static String solve(int n, int m, int q, Map<Integer, Map<Integer, Long>> graph, int[][] query) {
        return "";
    }

}
