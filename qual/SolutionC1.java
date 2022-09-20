import java.util.Scanner;

public class SolutionC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            String word = scanner.next();
            System.out.printf("Case #%d: %s\n", t + 1, solve(n, word));
        }
        scanner.close();
    }
    //

    public static String solve(int n, String word) {
        char first = word.charAt(0);
        char s = first == '.' ? '-' : '.';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append("\n");
            for (int j = 0; j < i + 1; j++) {
                sb.append(s);
            }
            sb.append(first);
        }
        return sb.toString();
    }
}
