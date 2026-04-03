import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b;
    static int minCnt = Integer.MAX_VALUE;
    static boolean flag = false;

    static void recur(long num, int depth){
//        System.out.println(num);

        if (num > b){
            return;
        }

        if (num == b){
            if (minCnt > depth){
                minCnt = depth;
                flag = true;
            }

            return;
        }

        // 2배 연산
        recur(num*2, depth+1);

        // 오른쪽에 1추가
        recur(num*10+1, depth+1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        recur(a, 0);

        if (!flag){
            System.out.println(-1);
            return;
        }

        System.out.println(minCnt+1);
    }
}
