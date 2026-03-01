import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] cnt = new long[M];
        long prefix = 0;
        long result = 0;

        // 시작 전 누적합 0
        cnt[0] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());

            prefix = (prefix + x) % M;
            cnt[(int) prefix]++;
        }

        for (int r = 0; r < M; r++) {
            result += cnt[r] * (cnt[r] - 1) / 2;
        }

        System.out.println(result);
    }
}