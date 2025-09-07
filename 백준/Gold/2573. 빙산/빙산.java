import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] visited;

    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 빙하 배열을 받는 부분
        // 2차원 배열은 for문 두개로 받아야 함
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N][M];
        System.out.println(checkYear());
    }

    static int[][] minusH(){
        int[][] hArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++){
                int cnt = 0;

                for (int d = 0; d < 4; d++){
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    if (ni >= 0 && ni < N && nj >= 0 && nj < M){
                        if (arr[i][j] != 0 && arr[ni][nj] == 0){
                            cnt ++;
                        }
                    }
                }
                hArr[i][j] = cnt;
            }

        }
        return hArr;
    }

    static void melting() {
        int[][] meltingH = minusH();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++){
                arr[i][j] -= meltingH[i][j];
                if (arr[i][j] < 0) arr[i][j] = 0;
            }
        }
    }

    static int[] findStart() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++){
                if (arr[i][j] != 0 && visited[i][j] == 0){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ti = cur[0];
            int tj = cur[1];

            for (int d = 0; d < 4; d++){
                int ni = ti + di[d];
                int nj = tj + dj[d];

                if (ni >= 0 && ni < N && nj >= 0 && nj < M){
                    if (visited[ni][nj] == 0 && arr[ni][nj] != 0){
                        visited[ni][nj] = 1;
                        q.add(new int[]{ni, nj});
                    }
                }
            }
        }
    }

    static boolean isZero() {
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (arr[i][j] != 0) return false;
            }
        }
        return true;
    }

    static int checkYear() {
        int cntYear = 0;

        while (!isZero()) {
            cntYear++;
            melting();

            int cnt = 0;
            visited = new int[N][M];

            while (true){
                int[] start = findStart();
                int si = start[0];
                int sj = start[1];

                if (si == -1) break;

                bfs(si, sj);
                cnt ++;

                if (cnt >= 2){
                    return cntYear;
                }
            }
        }
        return 0;
    }
}
