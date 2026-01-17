import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for (int i=0; i<str.length(); i++){
            char s = str.charAt(i);
            if ((s>='a') && (s<='z')) {
                sb.append((char) (s-'a'+'A'));
            }else{
                sb.append((char) (s-'A'+'a'));
            }
        }

        System.out.println(sb);
    }
}
