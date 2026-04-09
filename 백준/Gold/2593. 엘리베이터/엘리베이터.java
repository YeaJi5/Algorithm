import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int A, B;

    static int[] X;
    static int[] Y;

    static boolean[] visited;
    static int[] prev;
    static int[] dist;

    static boolean canStop(int elev, int floor) {
        if (floor < X[elev]) return false;
        return (floor - X[elev]) % Y[elev] == 0;
    }

    static boolean canTransfer(int i, int j) {
        // 더 적은 층에 서는 엘리베이터 쪽만 순회
        int cntI = (N - X[i]) / Y[i] + 1;
        int cntJ = (N - X[j]) / Y[j] + 1;

        if (cntI > cntJ) {
            int temp = i;
            i = j;
            j = temp;
        }

        for (int f = X[i]; f <= N; f += Y[i]) {
            if (canStop(j, f)) return true;
        }

        return false;
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        visited = new boolean[M + 1];
        prev = new int[M + 1];
        dist = new int[M + 1];

        // 시작층 A에 설 수 있는 엘리베이터들을 시작점으로
        for (int i = 1; i <= M; i++) {
            if (canStop(i, A)) {
                q.offer(i);
                visited[i] = true;
                dist[i] = 1;
                prev[i] = 0;
            }
        }

        int endElev = -1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (canStop(cur, B)) {
                endElev = cur;
                break;
            }

            for (int next = 1; next <= M; next++) {
                if (!visited[next] && canTransfer(cur, next)) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    prev[next] = cur;
                    q.offer(next);
                }
            }
        }

        if (endElev == -1) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int cur = endElev;
        while (cur != 0) {
            path.add(cur);
            cur = prev[cur];
        }

        Collections.reverse(path);

        System.out.println(path.size());
        for (int e : path) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        X = new int[M + 1];
        Y = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        bfs();
    }
}