import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxNum = 0;
        int maxIdx = 0;
        for(int i=1; i<=9; i++){
            int num = Integer.parseInt(br.readLine());

            if (maxNum<num){
                maxNum=num;
                maxIdx=i;
            }
        }

        sb.append(maxNum).append("\n").append(maxIdx);

        System.out.println(sb);
    }
}
