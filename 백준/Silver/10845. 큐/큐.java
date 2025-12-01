// BOJ_10845 큐

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static LinkedList<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            }else if(command.equals("pop")){
                if (!q.isEmpty()){
                    sb.append(q.poll());
                }else{
                    sb.append(-1);
                }
                sb.append('\n');
            }else if(command.equals("size")){
                sb.append(q.size()).append('\n');
            }else if(command.equals("empty")){
                if (q.isEmpty()){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append('\n');
            }else if(command.equals("front")){
                if (q.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(q.peek());
                }
                sb.append('\n');
            }else if(command.equals("back")){
                if (q.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(q.get(q.size()-1));
                }
                sb.append('\n');
            }
        }

        System.out.println(sb.toString());

    }
}
