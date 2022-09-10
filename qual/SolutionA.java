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
    }

    public static String solve(int N, int K, int[] A) {
    }
}