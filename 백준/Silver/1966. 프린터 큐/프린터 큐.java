import java.io.*;
import java.util.*;

public class Main {
    static class Doc {
        int idx, p;
        Doc(int idx, int p){
            this.idx = idx;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Doc> q = new ArrayDeque<>();
            int[] cnt = new int[10]; // priority 1~9

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.offer(new Doc(i, p));
                cnt[p]++;
            }

            int curMax = 9;
            while (curMax > 0 && cnt[curMax] == 0) curMax--;

            int printed = 0;

            while (true) {
                Doc now = q.poll();

                if (now.p == curMax) {          // 출력!
                    printed++;
                    cnt[curMax]--;

                    if (now.idx == M) {         // 내가 찾는 문서면 끝
                        sb.append(printed).append('\n');
                        break;
                    }

                    while (curMax > 0 && cnt[curMax] == 0) curMax--; // 다음 최대 찾기
                } else {
                    q.offer(now);               // 다시 뒤로
                }
            }
        }

        System.out.print(sb);
    }
}