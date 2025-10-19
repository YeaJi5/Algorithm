import java.io.*;
import java.util.*;

public class Main {
    static char[][] field;
    static boolean[][] visited;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Coord{
        int i, j;

        public Coord(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];

        for(int i=0; i<12; i++){
            String st = br.readLine();
            for(int j=0; j<6; j++){
                field[i][j] = st.charAt(j);
            }
        }

        boolean check = true;
        int resultCnt = 0;

        while(check){
            check = false;
            visited = new boolean[12][6];

            // 현재 상태에서 터질 수 있는 모든 블럭을 터뜨림
            for (int i=11; i>=0; i--){
                int cnt0 = 0;
                for (int j=0; j<6; j++){
                    if (field[i][j]!='.' && !visited[i][j]){
                        if (bfs(i, j, field[i][j])){
                            check = true;
                        }
                    }else if(field[i][j]=='.'){
                        cnt0++;
                    }
                }
            }

            if (check){
                resultCnt++;
                drop();
            }
        }

        System.out.println(resultCnt);
    }

    public static boolean bfs(int si, int sj, char temp){
        Queue<Coord> q = new LinkedList<>();
        Queue<Coord> t = new LinkedList<>();
        int cnt = 1;        // 연결된 블럭의 갯수

        q.add(new Coord(si, sj));
        visited[si][sj] = true;
        t.add(new Coord(si, sj));

        while(!q.isEmpty()){
            Coord cur = q.poll();
            int ti = cur.i;
            int tj = cur.j;

            for (int d=0; d<4; d++){
                int ni = ti + di[d];
                int nj = tj + dj[d];

                // 새로운 좌표가 허용된 범위 안
                if (ni<0 || ni>=12 || nj<0 || nj>=6) continue;

                if (!visited[ni][nj] && field[ni][nj]==temp){
                    visited[ni][nj] = true;
                    cnt++;
                    q.add(new Coord(ni, nj));
                    t.add(new Coord(ni, nj));
                }
            }
        }

        // 인접한 블록이 4개 이상이면 true를 반환
        if (cnt>=4){
            while (!t.isEmpty()){
                Coord curt = t.poll();
                field[curt.i][curt.j] = '.';
            }
            return true;
        }
        return false;
    }

    public static void drop() {
        for (int i=0; i<6; i++) {  // 각 열마다 따로 떨어뜨리기
            int bottom = 11;  // 🔥 열이 바뀔 때마다 초기화
            for (int j=11; j>=0; j--) {
                if (field[j][i] != '.') {
                    field[bottom][i] = field[j][i];
                    if (bottom != j) field[j][i] = '.';
                    bottom--; // 다음 칸 위로
                }
            }
        }
    }

}
