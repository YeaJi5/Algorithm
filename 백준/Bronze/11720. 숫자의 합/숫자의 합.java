import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();

        int numSum = 0;
        for (int i=0; i<N; i++){
            char charNum = num.charAt(i);

            numSum += (charNum -'0');
        }

        System.out.println(numSum);
    }
}
