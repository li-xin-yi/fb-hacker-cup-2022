import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SolutionC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int T = scanner.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int D = scanner.nextInt();
            int[][] points = new int[N][2];
            for(int i = 0; i < N; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            System.out.println("Case #" + t + ": " + solve(N, D, K, points));
        }
        scanner.close();
    }

    private static long solve(int N, int D, int K, int[][] points) {
        List<int[]> hull = convexHull(points, N);
        int M = hull.size();
        Map<Integer,Long> cost = new HashMap<>();
        cost.put(0,0L);
        for(int i = 1; i < M; i++) {
            cost.put(i, Long.MAX_VALUE);
        }
        while(!cost.isEmpty()) {
            int idx = minIndex(cost);
            if(idx == -1) return -1L;
            
            long curCost = cost.remove(idx);
            if(idx == M-1) return curCost;
            for(int nei: cost.keySet()) {
                long d = dist(hull.get(idx), hull.get(nei));
                long delta = Math.max(K, d);
                if(d <= (long)D*D && curCost + delta < cost.get(nei)) {
                    cost.put(nei, curCost + delta);
                } 
            }
        }
        
        return 0L;
    }

    private static long cross(int[] a, int[] b, int[] c) {
        return (long)(b[0] - a[0]) * (c[1] - a[1]) - (long)(b[1] - a[1]) * (c[0] - a[0]);
    }

    private static long dist(int[] a, int[] b) {
        return (long)(a[0] - b[0]) * (a[0] - b[0]) + (long)(a[1] - b[1]) * (a[1] - b[1]);
    }

    private static int minIndex(Map<Integer,Long> cost) {
        int minIdx = -1;
        long minCost = Long.MAX_VALUE;
        for(int idx : cost.keySet()) {
            long c = cost.get(idx);
            if(c < minCost) {
                minIdx = idx;
                minCost = c;
            }
        }
        return minIdx;
    }

    private static List<int[]> convexHull(int[][] points, int n) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] lower = new int[n];
        int lowerSize = 0;
        for (int i = 0; i < n; i++) {
            while (lowerSize >= 2 && cross(points[lower[lowerSize - 2]], points[lower[lowerSize - 1]], points[i]) <= 0) {
                lowerSize--;
            }
            lower[lowerSize++] = i;
        }
        int[] upper = new int[n];
        int upperSize = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (upperSize >= 2 && cross(points[upper[upperSize - 2]], points[upper[upperSize - 1]], points[i]) <= 0) {
                upperSize--;
            }
            upper[upperSize++] = i;
        }
        List<int[]> hull = new ArrayList<>();
        for (int i = 0; i < lowerSize - 1; i++) {
            hull.add(points[lower[i]]);
        }
        for (int i = 1; i < upperSize - 1; i++) {
            hull.add(points[upper[i]]);
        }
        hull.add(points[n-1]);
        return hull;
    }
}