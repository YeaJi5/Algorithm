import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int floor = (p-1) % h + 1;
            int num = (p-1) / h + 1;

            int roomNumber = (floor)*100 + (num);

            sb.append(roomNumber).append('\n');
        }

        System.out.println(sb.toString());
    }
}
