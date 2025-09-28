import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char check_str(String str){
        int[] alpha = new int[26];

        int index = 0;
        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            char upper_c = Character.toUpperCase(c);

            index = upper_c -'A';
            alpha[index]++;
        }

        int maxCnt = -1;
        char result = '?';

        for (int i=0; i<26; i++){
            if (alpha[i] > maxCnt){
                maxCnt = alpha[i];
                result = (char)(i+'A');
            } else if (alpha[i] == maxCnt){
                result = '?';
            }
        }

        return result;

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char result = check_str(str);

        System.out.println(result);
    }
}
