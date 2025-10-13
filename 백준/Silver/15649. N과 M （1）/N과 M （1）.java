import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[N];
        result = new int[M];

        for (int i=0; i<N; i++){
            arr[i] = i+1;
        }

        recur(0);

    }

    public static void recur(int cnt){
        if (cnt == M){
            for (int i=0; i<M; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=0; i<N; i++){
            if (!visited[i]){
                visited[i] = true;
                result[cnt] = arr[i];

                recur(cnt+1);

                visited[i] = false;
            }
        }
    }
}
