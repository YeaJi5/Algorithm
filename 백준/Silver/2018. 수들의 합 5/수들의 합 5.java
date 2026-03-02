import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i=1; i<=N; i++){
            int sum = 0;

            int p2 = i;
            while (true){
                sum += p2;
                p2++;

                if (sum == N){
                    result++;
                } else if (sum > N) {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
