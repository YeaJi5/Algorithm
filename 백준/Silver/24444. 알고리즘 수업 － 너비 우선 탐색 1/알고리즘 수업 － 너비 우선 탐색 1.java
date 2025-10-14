import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 인접 리스트를 저장하기 위한 이차원 배열을 미리 선언
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int N, M, R;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        R = Integer.parseInt(st1.nextToken());      // 시작 정점

        // 정점의 번호는 1부터 N까지
        // 원래는 boolean으로 사용하는데, 방문 순서대로 번호를 매길 예정
        visited = new int[N+1];

        // 비어있는 배열을 추가해줌
        for (int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        // 인접리스트 만들기
        for (int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            addEdge(a, b);
        }

        bfs(R);

        for (int i=1; i<=N; i++){
            System.out.println(visited[i]);
        }

    }

    public static void addEdge(int a, int b){
        // 배열의 a번째 행을 가져와서 b원소 추가
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        int cnt = 1;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()){
            int node = q.poll();

            // 정렬을 해서 넣어주자
            ArrayList<Integer> nextList = graph.get(node);
            Collections.sort(nextList);
            for (int next : nextList){
                if (visited[next] == 0){
                    visited[next] = cnt+1;
                    cnt++;
                    q.add(next);
                }
            }

        }
    }
}
