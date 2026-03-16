import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<String> nameList = new HashSet<>();
        ArrayList<String> sortedList = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++){
            nameList.add(br.readLine());
        }

        for (int i=0; i<M; i++){
            String n = br.readLine();

            if (nameList.contains(n)) {
                sortedList.add(n);
            }
        }

        Collections.sort(sortedList);
        
        sb.append(sortedList.size()).append('\n');
        for (int i=0; i<sortedList.size(); i++){
            sb.append(sortedList.get(i)).append('\n');
        }

        System.out.println(sb.toString());
    }
}
