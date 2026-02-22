import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static char[][] board;
    public static int n, m;

    // W로 시작하는 경우로 체크 만들기
    public static int startW(char[][] board){
        int result = 0;

        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (i%2 == 0){
                    if (j%2 == 0) {
                        if (board[i][j] != 'W') result++;
                    }else {
                        if (board[i][j] != 'B') result++;
                    }
                } else {
                    if (j%2 == 0) {
                        if (board[i][j] != 'B') result++;
                    }else {
                        if (board[i][j] != 'W') result++;
                    }
                }
            }
        }

        return result;
    }

    // B로 시작하는 경우로 체크 만들기
    public static int startB(char[][] board){
        int result = 0;

        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (i%2 == 0){
                    if (j%2 == 0) {
                        if (board[i][j] != 'B') result++;
                    }else {
                        if (board[i][j] != 'W') result++;
                    }
                } else {
                    if (j%2 == 0) {
                        if (board[i][j] != 'W') result++;
                    }else {
                        if (board[i][j] != 'B') result++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<m; j++){
                board[i][j] = str.charAt(j);
            }
        }

        int result = 3000;

        for (int i=0; i<n-8+1; i++){
            for (int j=0; j<m-8+1; j++){

                char[][] newBoard = new char[8][8];

                for (int k=0; k<8; k++){
                    for (int l=0; l<8; l++){
                        newBoard[k][l] = board[i+k][j+l];
                    }
                }

                result = Math.min(result, startB(newBoard));
                result = Math.min(result, startW(newBoard));
            }
        }

        System.out.println(result);
    }
}
