import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;

    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer>[] graph;

    public static void dfs(int n){
        visitedDFS[n] = true;
        sb.append(n).append(' ');

        for (int next : graph[n]) {
            if (!visitedDFS[next]){
                dfs(next);
            }
        }
    }

    public static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visitedBFS[n] = true;
        sb.append(n).append(' ');

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visitedBFS[next]){
                    visitedBFS[next] = true;
                    sb.append(next).append(' ');
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visitedDFS = new boolean[N+1];
        visitedBFS = new boolean[N+1];

        graph = new ArrayList[N+1];
        for (int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for (int i=0; i<=N; i++){
            Collections.sort(graph[i]);
        }

        dfs(V);

        sb.append('\n');

        bfs(V);

        System.out.println(sb);
    }
}
