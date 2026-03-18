import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] setList = new HashSet[N+1];

        for (int i=0; i<=N; i++) {
            setList[i] = new HashSet<>();
        }

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()){
                setList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());

            if (q == 1){
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());

                if (setList[s1].size() > setList[s2].size()){
                    setList[s1].addAll(setList[s2]);

                    setList[s2].clear();
                } else {
                    // 작은쪽에서 큰 쪽으로 합칠 수 있도록 두 개를 바꿔줌
                    setList[0] = setList[s1];
                    setList[s1] = setList[s2];
                    setList[s2] = setList[0];

                    setList[s1].addAll(setList[s2]);

                    setList[s2].clear();
                }

                setList[s2] = new HashSet<>();
            } else {
                int s = Integer.parseInt(st.nextToken());

                sb.append(setList[s].size()).append('\n');
            }
        }

        System.out.println(sb);
    }
}
