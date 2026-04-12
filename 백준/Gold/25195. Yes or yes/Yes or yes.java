import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int n, m, s;
    static ArrayList<Integer>[] graph;
    static HashSet<Integer> gom = new HashSet<>();
    static String result = "Yes";

    static void dfs(int n, boolean flag){
        if (graph[n].isEmpty()){
            // 끝까지 왔는데 팬클럽을 만나지 않았다면
            if (!flag) {
                result = "yes";
            }
            return;
        }

        for ( int next : graph[n]) {
            // 해당 노드에 팬클럽이 있는 경우
            if (gom.contains(next)) {
                // flag를 true로 변경
                dfs(next, true);
            } else {
                // flag를 그대로 넘겨줌
                dfs(next, flag);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 정점의 번호는 1부터 n까지
        graph = new ArrayList[n+1];
        for (int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 정점 u에서 v로 가는 간선
            graph[u].add(v);
        }

        // 팬클럽이 존재하는 정점의 번호
        s = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<s; i++){
            gom.add(Integer.parseInt(st.nextToken()));
        }

        boolean flag = false;
        if (gom.contains(1)){
            flag = true;
        }

        dfs(1, flag);

        System.out.println(result);

    }
}
