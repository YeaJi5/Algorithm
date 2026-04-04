import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 열은 각각 cnt0, cnt1
        int[][] memo = new int[41][2];
        memo[0][0] = 1; memo[0][1] = 0;
        memo[1][0] = 0; memo[1][1] = 1;

        for (int i=2; i<=40; i++){
            memo[i][0] = memo[i-1][0] + memo[i-2][0];
            memo[i][1] = memo[i-1][1] + memo[i-2][1];
        }


        for (int tc=0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            sb.append(memo[N][0]).append(' ').append(memo[N][1]).append('\n');
        }

        System.out.println(sb);

    }
}
