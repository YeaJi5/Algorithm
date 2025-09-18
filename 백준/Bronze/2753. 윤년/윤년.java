import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        int num = Integer.parseInt(line1.trim());

        if ((num%4 == 0) && ((num%100 != 0) || (num%400 == 0))){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
