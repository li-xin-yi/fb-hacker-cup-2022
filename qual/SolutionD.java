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
        // preprocess
        Map<Integer, Map<Integer, Long>> pre = new HashMap<>();
        for (int u : graph.keySet()) {
            int d = graph.get(u).size();
            if (d * d >= m) {
                pre.put(u, new HashMap<>());
                for (int k : graph.get(u).keySet()) {
                    for (int v : graph.get(k).keySet()) {
                        if (u == v)
                            continue;
                        long w = Math.min(graph.get(u).get(k), graph.get(k).get(v));
                        pre.get(u).put(v, pre.get(u).getOrDefault(v, 0L) + w);
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int u = query[i][0];
            int v = query[i][1];
            Map<Integer, Long> uEdges = graph.getOrDefault(u, new HashMap<>());
            Map<Integer, Long> vEdges = graph.getOrDefault(v, new HashMap<>());
            if (uEdges.size() < vEdges.size()) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            long w = graph.getOrDefault(u, new HashMap<>()).getOrDefault(v, 0L) * 2;
            if (pre.containsKey(u)) {
                w += pre.get(u).getOrDefault(v, 0L);
            } else {
                for (int k : uEdges.keySet()) {
                    if (vEdges.containsKey(k)) {
                        w += Math.min(uEdges.get(k), vEdges.get(k));
                    }
                }
            }
            res.append(' ').append(w);
        }
        return res.toString();
    }
}
