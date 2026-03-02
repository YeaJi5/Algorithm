import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] num = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            num[i] = Long.parseLong(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(num);

        int result = 0;

        // num[k]는 타겟 숫자
        for (int k=0; k<N; k++){
            int s = 0;
            // 값이 음의 정수일 수 도 있어서 전체적으로 확인해야함!
            int e = N-1;

            while (s < e) {
                if (num[s] + num[e] > num[k]){
                    e--;
                } else if (num[s] + num[e] < num[k]){
                    s++;
                } else {
                    //  서로 다른 두 수의 합인지 확인해야 함!
                    if (s != k && e != k){
                        result++;
                        break;
                    } else if (s == k){
                        s++;
                    } else if (e == k){
                        e--;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
