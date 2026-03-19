import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;
        int i = 0;

        while (i < str.length()) {
            // 1. dz= 먼저 확인 (3글자)
            if (i + 2 < str.length() && str.substring(i, i + 3).equals("dz=")) {
                count++;
                i += 3;
            }
            // 2. 2글자짜리 크로아티아 알파벳 확인
            else if (i + 1 < str.length()) {
                String two = str.substring(i, i + 2);

                if (two.equals("c=") || two.equals("c-") ||
                    two.equals("d-") || two.equals("lj") ||
                    two.equals("nj") || two.equals("s=") ||
                    two.equals("z=")) {
                    count++;
                    i += 2;
                } else {
                    count++;
                    i++;
                }
            }
            // 3. 마지막 한 글자
            else {
                count++;
                i++;
            }
        }

        System.out.println(count);
    }
}