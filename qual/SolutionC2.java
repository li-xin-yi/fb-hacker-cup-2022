import java.util.Scanner;

public class SolutionC2 {
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

    public static String solve(int n, String word) {
        char start = word.charAt(0);
        char first = start == '.' ? '-' : '.';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            String binary = Integer.toBinaryString(i);
            String padding = String.format("%9s", binary).replace(' ', '.');
            String s = padding.replace('0', '.').replace('1', '-');
            sb.append('\n').append(first).append(s);
        }
        return sb.toString();
    }
}
