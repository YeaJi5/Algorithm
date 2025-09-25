import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int minNum = 1000000;
        int maxNum = -1000000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if (num > maxNum){
                maxNum = num;
            }
            if(num < minNum) {
                minNum = num;
            }
        }

        System.out.println(minNum + " " + maxNum);
    }
}
