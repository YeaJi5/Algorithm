import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for (int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            // 1은 소수가 아님 !
            if (num == 1){
                continue;
            }

            if (num == 2){
                cnt++;
                continue;
            }

            boolean flag = false;
            for (int j=2; j<num; j++){
                if (num % j == 0){
                    flag = true;
                    break;
                }
            }

            if (!flag){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
