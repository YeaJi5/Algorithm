import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());

        int q = 0;
        if (X > 0 && Y > 0){
            q = 1;
        }else if(X < 0 && Y > 0){
            q = 2;
        }else if(X < 0 && Y < 0){
            q = 3;
        }else{
            q = 4;
        }

        System.out.println(q);

    }
}
