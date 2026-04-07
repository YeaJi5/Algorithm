import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {   // i가 N의 약수이면
                count++;

                if (count == K) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}