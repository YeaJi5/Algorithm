import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=1; i<=N; i++){
            list.add(i);
        }

        // System.out.println(list);

        sb.append('<');

        int s = list.size();
        int tempIdx = 0;
        while (s > 0){
            int idx = tempIdx+K-1;

            if (idx >= s){
                // idx의 값이 현재 배열의 길이를 넘으면 배열의 길이의 나머지
                idx %= s;
            }

            // 해당 원소를 순열에 추가해주고 배열에서 삭제
            if (s==1){
                sb.append(list.get(idx)).append('>');
            }else{
                sb.append(list.get(idx)).append(",").append(" ");
            }

            list.remove(idx);

            // 전체 배열의 길이 감소
            s -= 1;
            // 현재 위치 갱신
            tempIdx = idx;
        }

        System.out.println(sb);
    }
}
