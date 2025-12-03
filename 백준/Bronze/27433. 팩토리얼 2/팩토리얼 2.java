import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        result = 1;
        factorial(1);

        System.out.println(result);

    }

    public static void factorial(int n){
        if(n>N){
            return;
        }

        result = n*result;
        factorial(++n);
    }
}
