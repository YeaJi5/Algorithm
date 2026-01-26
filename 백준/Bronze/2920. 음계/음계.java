import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());

        if (first == 1){
            for (int i=2; i<=8; i++){
                int num = Integer.parseInt(st.nextToken());
                if (num != i){
                    System.out.println("mixed");
                    return;
                }
            }

            System.out.println("ascending");

        } else if(first == 8){
            for (int i=7; i>=1; i--){
                int num = Integer.parseInt(st.nextToken());
                if (num != i){
                    System.out.println("mixed");
                    return;
                }
            }

            System.out.println("descending");

        }else {
            System.out.println("mixed");
        }
    }
}
