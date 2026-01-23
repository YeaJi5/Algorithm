import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int N = A * B * C;
        int[] num = new int [10];

        while (N != 0){
            num[N%10]++;
            N /= 10;
        }

        for (int i=0; i<10; i++){
            sb.append(num[i]).append('\n');
        }

        System.out.println(sb);
    }
}
