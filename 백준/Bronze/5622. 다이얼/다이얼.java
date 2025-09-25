import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dial = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        String str = br.readLine();
        int time = 0;

        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            for (int j=0; j<dial.length; j++){
                if (dial[j].contains(String.valueOf(c))) {
                    time += j+3;
                    break;
                }
            }
        }

        System.out.println(time);
    }
}
