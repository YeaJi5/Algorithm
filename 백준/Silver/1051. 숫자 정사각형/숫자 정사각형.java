import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] square;

    public static boolean checkNum(int i, int j, int num){
        int sNum = square[i][j];

        if (sNum == square[i+num-1][j]
                && sNum == square[i][j+num-1]
                && sNum == square[i+num-1][j+num-1]) return true;

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int len = Math.min(n, m);

        if (len == 1) {
            System.out.println(1);
            return;
        }

        square = new int[n][m];

        for (int i=0; i<n; i++){
            String line = br.readLine();
            for (int j=0; j<m; j++){
                square[i][j] = line.charAt(j) - '0';
            }
        }

        int result = 1;

        // 최대 변의 길이
        for (int num=2; num<=len; num++){
            for (int i=0; i<n-num+1; i++){
                for (int j=0; j<m-num+1; j++){
                    // 슬라이딩 윈도우
                    if (checkNum(i, j, num)){
                        result = Math.max(result, num*num);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
