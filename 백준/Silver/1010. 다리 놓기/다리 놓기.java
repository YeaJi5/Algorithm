import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 조합을 미리 계산해야함
        for (int i=0; i<=30; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;

            for (int j=1; j<i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(dp[m][n]).append('\n');

        }

        System.out.println(sb.toString());
    }
}
