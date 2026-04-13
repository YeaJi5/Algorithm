import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc=0; tc<t; tc++){
            HashSet<String> set = new HashSet<>();

            String str = br.readLine();

            while (true){
                st = new StringTokenizer(br.readLine());
                String animal = st.nextToken();

                if (animal.equals("what")){
                    break;
                }

                String g = st.nextToken();

                String cries = st.nextToken();

                set.add(cries);
            }

            st = new StringTokenizer(str);
            while (st.hasMoreTokens()){
                String c = st.nextToken();
                if (!set.contains(c)){
                    sb.append(c).append(" ");
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
