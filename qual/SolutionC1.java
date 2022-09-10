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
    }

    public static String solve(int n, String word){
        
    }
}
