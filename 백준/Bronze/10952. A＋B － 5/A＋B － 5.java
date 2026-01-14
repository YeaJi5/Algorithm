import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean fin = false;
        while (!fin) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if ((num1==0) && (num2==0)){
                fin = true;
                break;
            } else {
                int result = num1 + num2;
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);

    }
}
