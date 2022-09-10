import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
class SolutionB2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String[] grid = new String[n];
            for (int i = 0; i < n; i++) {
                grid[i] = scanner.next();
            }
            System.out.printf("Case #%d: %s\n", t + 1, solve(n, m, grid));
    }
}

    public static String solve(int n, int m, String[] grid) {
        
    }


}