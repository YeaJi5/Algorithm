import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐 이용해서 풀기

public class Main {
    public static void main(String args[]) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i<=N; i++){
            q.add(i);
        }

        int cnt = 0;
        int num;

        sb.append('<');
        // 큐에 원소가 남아있다면 계속 반복
        while (!q.isEmpty()){
            for (int i=0; i<K-1; i++){
                num = q.poll();
                q.add(num);
            }
            num = q.poll();
            sb.append(num);

            if (!q.isEmpty()){
                sb.append(",").append(" ");
            }
        }
        sb.append('>');

        System.out.println(sb);
    }
}
