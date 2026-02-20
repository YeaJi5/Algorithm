import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a의 제일 뒷자리 숫자만 가져옴
            int last = a % 10;
            int result = 1;

            int cycle = b % 4;
            if (cycle == 0) cycle = 4;

            for (int i=0; i<cycle; i++){
                result = (result * last) % 10;
            }

            if(result == 0) result = 10;

            sb.append(result).append('\n');
        }

        System.out.println(sb.toString());
    }
}
