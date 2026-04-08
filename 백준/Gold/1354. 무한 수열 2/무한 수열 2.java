import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static long N;
    static int P, Q, X, Y;

    static Map<Long, Long> map = new HashMap<>();

    static long recur(long num){
        if (num <= 0){
            return 1;
        }

        if (map.containsKey(num)){
            return map.get(num);
        }

        long result = recur(num/P-X) + recur(num/Q-Y);
        map.put(num, result);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        System.out.println(recur(N));
    }
}
