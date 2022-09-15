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
        scanner.close();
    }

    public static String solve(int n, int m, String[] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] nei = new int[n][m];
        boolean[][] seen = new boolean[n][m];
        for (int[] row : nei) {
            Arrays.fill(row, 4);
        }
        for (int i = 0; i < n; i++) {
            nei[i][0]--;
            nei[i][m - 1]--;
        }
        for (int j = 0; j < m; j++) {
            nei[0][j]--;
            nei[n - 1][j]--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '#' || nei[i][j] < 2) {
                    if (grid[i].charAt(j) == '^')
                        return "Impossible";
                    q.add(new int[] { i, j });
                    seen[i][j] = true;
                }
            }
        }

        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];
            for (int[] dir : directions) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && !seen[x][y]) {
                    if (--nei[x][y] < 2) {
                        if (grid[x].charAt(y) == '^')
                            return "Impossible";
                        q.offer(new int[] { x, y });
                        seen[x][y] = true;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder("Possible");
        for (int i = 0; i < n; i++) {
            res.append("\n");
            for (int j = 0; j < m; j++) {
                if (seen[i][j]) {
                    res.append(grid[i].charAt(j));
                } else {
                    res.append('^');
                }
            }
        }
        return res.toString();
    }

}