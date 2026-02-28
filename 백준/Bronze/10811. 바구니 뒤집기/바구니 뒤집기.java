import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N+1];
        for (int i=1; i<=N; i++){
            basket[i] = i;
        }

        for (int tc=0; tc<M; tc++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int c = 0;
            for (int k = i; k < i + (j - i + 1) / 2; k++) {
                int temp = basket[k];
                basket[k] = basket[j - c];
                basket[j - c] = temp;
                c++;
            }
        }

        for (int i=1; i<=N; i++){
            sb.append(basket[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
