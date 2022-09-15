import java.util.Arrays;
import java.util.Scanner;
class SolutionB1 {
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
        if (n == 1 || m == 1) {
            for (String s : grid) {
                if (s.contains("^")) {
                    return "Impossible";
                }
            }
            String ret = "Possible";
            for (String s : grid) {
                // int leng = s.length();
                // char[] array = new char[leng];
                // Arrays.fill(array, '.');
                ret = ret + "\n" + s;
            }
            return ret;
        }
        String ret = "Possible";
        for (String s : grid) {
                 int leng = s.length();
                char[] array = new char[leng];
                Arrays.fill(array, '^');
                ret = ret + "\n" + String.valueOf(array);
        }
        return ret;
    }

} 