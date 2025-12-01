import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a==0 && b==0 && c==0){
                System.out.println(sb);
                return;
            }

            double a2 = Math.pow(a, 2);
            double b2 = Math.pow(b, 2);
            double c2 = Math.pow(c, 2);

            if (a2+b2==c2 || a2+c2==b2 || b2+c2==a2){
                sb.append("right").append("\n");
            }else{
                sb.append("wrong").append("\n");
            }
        }
    }
}
