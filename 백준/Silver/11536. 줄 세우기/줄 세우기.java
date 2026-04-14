import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < N - 1; i++) {
            int cmp = names[i].compareTo(names[i + 1]);

            if (cmp >= 0) {
                increasing = false;
            }
            if (cmp <= 0) {
                decreasing = false;
            }
        }

        if (increasing) {
            System.out.println("INCREASING");
        } else if (decreasing) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}