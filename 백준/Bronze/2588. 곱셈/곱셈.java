import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        int A = Integer.parseInt(line1.trim());

        String line2 = br.readLine();
        int B = Integer.parseInt(line2.trim());

        int result = 0;
        for (int i = 0; i < 3; i++){
            int temp = A*(B%10);
            System.out.println(temp);
            result += temp*(int)Math.pow(10, i);
            B = B/10;
        }
    System.out.println(result);
    }
}
