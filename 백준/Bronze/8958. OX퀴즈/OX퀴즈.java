import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc=0; tc<T; tc++){
            String str = br.readLine();

            char prev = 'X';
            int total = 0;
            int score = 1;

            for (int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if (c == 'O'){
                    if (c == prev){
                        score++;
                        total += score;
                    } else {
                        score = 1;
                        total += score;
                    }

                    prev = 'O';
                } else {
                    prev = 'X';
                    score = 1;
                }
            }

            sb.append(total).append('\n');
        }

        System.out.println(sb.toString());
    }
}
