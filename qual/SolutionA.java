import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SolutionA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }
            System.out.printf("Case #%d: %s\n", t + 1, solve(N, K, A));
        }
        scanner.close();
    }

    public static String solve(int N, int K, int[] A) {
        Map<Integer, Integer> map =new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > 2) {
                return "NO";
            }
        }
        if (N > K * 2) {
            return "NO";
        }
        return "YES";
    }
}