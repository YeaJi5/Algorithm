import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[] visited;
    static int cnt = 1;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList <>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];

        // 그래프에 빈 배열 추가
        for (int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            addEdge(a, b);
        }

        // 인접 정점은 오름차순으로 방문
        for (int i=0; i<=N; i++){
            Collections.sort(graph.get(i));
        }

        dfs(R);

        for (int i=1; i<=N; i++){
            System.out.println(visited[i]);
        }
    }

    public static void addEdge(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public static void dfs(int start){
        visited[start] = cnt;
        cnt++;

        for (int next: graph.get(start)){
            if (visited[next]==0){
                dfs(next);
            }
        }
    }
}
