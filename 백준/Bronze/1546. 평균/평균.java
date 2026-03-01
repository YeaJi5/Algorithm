import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        float[] score = new float[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            score[i] = Float.parseFloat(st.nextToken());
        }

        float maxScore = 0;
        for (int i=0; i<N; i++){
            if (score[i] > maxScore){
                maxScore = score[i];
            }
        }

        for (int i=0; i<N; i++){
            score[i] = (score[i]/maxScore)*100;
        }

        float sumScore = 0;
        for (int i=0; i<N; i++){
            sumScore += score[i];
        }

        System.out.println(sumScore/N);
    }
}
