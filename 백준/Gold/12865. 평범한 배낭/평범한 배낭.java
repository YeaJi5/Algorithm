import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static int[][] bag;
    static int maxValue = 0;

    static int[][] memo;

    static int dfs(int idx, int w){
        if (w > k){
            return Integer.MIN_VALUE;
        }

        if (idx == n){
            return 0;
        }

        if (memo[idx][w] != -1){
            return memo[idx][w];
        }

        int v = -1;

        // 물건을 챙김
        v = Math.max(v, dfs(idx+1, w+bag[idx][0])+bag[idx][1]);

        // 물건을 챙기지 않음
        v = Math.max(v, dfs(idx+1, w));

        return memo[idx][w] = v;
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bag = new int[n][2];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 0은 무게, 1은 가치
            bag[i][0] = w;
            bag[i][1] = k;
        }

        memo = new int[n][111111];
        for (int i=0; i<n; i++){
            Arrays.fill(memo[i], -1);
        }

        System.out.println(dfs(0, 0));
    }
}
