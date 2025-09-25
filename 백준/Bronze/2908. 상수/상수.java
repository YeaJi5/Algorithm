import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String num1 = st.nextToken();
        String num2 = st.nextToken();

        int num = 100;
        int new_num1 = 0;
        int new_num2 = 0;
        for (int i=2; i>=0; i--){
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(i);

            new_num1 += num*(c1-'0');
            new_num2 += num*(c2-'0');
            num /= 10;
        }

        System.out.println(Math.max(new_num1, new_num2));
    }
}
