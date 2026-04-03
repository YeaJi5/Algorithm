import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<List<Integer>> set = new HashSet<>();
    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    static void recur(int depth){
        if (depth == M) {
            List<Integer> num = new ArrayList<>();

            for (int i=0; i<M; i++){
                sb.append(result[i]).append(' ');
            }

            set.add(num);
            return;
        }

        int prev = -1;

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (arr[i] == prev) continue;

            visited[i] = true;
            result[depth] = arr[i];
            prev = arr[i];

            recur(depth + 1);

            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        recur(0);

        System.out.print(sb);
    }
}
