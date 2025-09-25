import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int tc=0; tc<N; tc++){
            String str = br.readLine();

            char s = str.charAt(0);
            char e = str.charAt(str.length()-1);

            sb.append(s).append(e).append('\n');
        }

        System.out.println(sb);
    }
}
