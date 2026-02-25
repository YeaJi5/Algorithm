import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String isbn = br.readLine();
        int sum = 0;
        int k = 0;

        for (int i=0; i<13; i++){
            char num = isbn.charAt(i);

            if (num != '*'){
                int n = num - '0';
                if (i%2 == 0){
                    sum += n;
                } else {
                    sum += n*3;
                }
            } else {
                k = i;
            }
        }

        int result = (10-(sum%10))%10;

        if (k%2 != 0) {
            result = (7*result)%10;
        }

        System.out.println(result);
    }
}
