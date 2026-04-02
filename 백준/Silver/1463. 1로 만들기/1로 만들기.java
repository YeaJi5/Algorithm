import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] memo;

    static int dfs(int n){
        // 이미 목표에 도착해서 연산횟수가 0번이다..?
        // dfs(1) = 0 이라는 뜻
        if (n == 1){
            return 0;
        }

        int a = Integer.MAX_VALUE;

        if (memo[n] != -1){
            return memo[n];
        }

        // /3
        if (n%3 == 0){
            a = Math.min(a, dfs(n/3)+1);
        }

        // /2
        if (n%2 == 0){
            a = Math.min(a, dfs(n/2)+1);
        }

        // -1
        a = Math.min(a, dfs(n-1)+1);

        return memo[n] = a;
    }

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        memo = new int[n+1];
        Arrays.fill(memo, -1);

        System.out.println(dfs(n));
    }
}
