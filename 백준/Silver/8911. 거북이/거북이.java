import java.util.*;
import java.io.*;

// F: 한 눈금 앞으로
// B: 한 눈금 뒤로
// L: 왼쪽으로 90도 회전
// R: 오른쪽으로 90도 회전

public class Main {

    // 동 남 서 북 순서
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++){
            String move = br.readLine();

            sb.append(moveTuttle(move)).append('\n');
        }

        System.out.println(sb);
    }

    public static int moveTuttle(String move){
        int minX = 0, minY = 0, maxX = 0, maxY = 0;
        int coordX = 0, coordY=0;
        int temp_dir = 3;
        int N = move.length();

        for(int i=0; i<N; i++){
            char temp = move.charAt(i);

            if (temp=='F'){
                coordX += dir[temp_dir][0];
                coordY += dir[temp_dir][1];
            }else if(temp=='B'){
                int rev_dir = (temp_dir+2)%4;
                coordX += dir[rev_dir][0];
                coordY += dir[rev_dir][1];
            }else if(temp=='L'){
                temp_dir = (temp_dir+3)%4;
            }else{
                temp_dir = (temp_dir+1)%4;
            }

            minX = Math.min(minX, coordX);
            minY = Math.min(minY, coordY);
            maxX = Math.max(maxX, coordX);
            maxY = Math.max(maxY, coordY);
        }

        int result = (maxX-minX)*(maxY-minY);
        return result;
    }
}
