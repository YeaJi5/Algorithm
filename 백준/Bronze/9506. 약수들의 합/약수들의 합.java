import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            List<Integer> list = new ArrayList<>();
            list.add(1); // 1은 항상 포함

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    if (i != n / i) {
                        list.add(n / i);
                    }
                }
            }

            Collections.sort(list);

            int sum = 0;
            for (int num : list) {
                sum += num;
            }

            if (sum == n) {
                sb.append(n).append(" = ");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i != list.size() - 1) sb.append(" + ");
                }
                sb.append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }
        }

        System.out.print(sb);
    }
}