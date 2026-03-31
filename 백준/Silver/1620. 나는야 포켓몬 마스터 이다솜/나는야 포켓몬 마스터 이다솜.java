import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] pokemon = new String[N+1];

        for (int i=1; i<=N; i++){
            String name = br.readLine();
            pokemon[i] = name;
            map.put(name, i);
        }

        for (int i=0; i<M; i++){
            String str = br.readLine();

            int t = str.charAt(0)-'A';

            if (t < 0 || t > 'Z'-'A') {
                int num = Integer.parseInt(str);
                sb.append(pokemon[num]).append('\n');
            } else {
                sb.append(map.get(str)).append('\n');
            }
        }

        System.out.println(sb);
    }
}
