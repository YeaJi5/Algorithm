import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int N, M, R;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        R = Integer.parseInt(st1.nextToken());

        // N번 인덱스까지 빈 배열 추가
        for (int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        // visited 배열 크기를 정해줌
        visited = new int[N+1];

        // 인접 리스트 생성
        for (int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            addEdge(a, b);
        }

        for (int i=0; i<=N; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        bfs(R);

        for (int i=1; i<=N; i++){
            System.out.println(visited[i]);
        }
    }

    public static void addEdge(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        int cnt = 1;

        while (!q.isEmpty()){
            int node = q.poll();

            for (int next : graph.get(node)){
                if (visited[next] == 0){
                    visited[next] = cnt+1;
                    cnt++;
                    q.add(next);
                }
            }
        }
    }
}
