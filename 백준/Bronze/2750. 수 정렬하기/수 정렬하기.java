import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        for (int i=0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<N; i++){
            for (int j=i+1; j<N; j++){
                if (num[i] > num[j]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
            sb.append(num[i]).append('\n');
        }
        System.out.println(sb);
    }
}
