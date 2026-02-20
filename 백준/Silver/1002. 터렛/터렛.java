import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long r1 = Long.parseLong(st.nextToken());

            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            long r2 = Long.parseLong(st.nextToken());

            long dx = x1 - x2;
            long dy = y1 - y2;

            long dist2 = dx * dx + dy * dy;          // 중심거리 제곱
            long sum = r1 + r2;
            long sum2 = sum * sum;                   // (r1+r2)^2
            long diff = Math.abs(r1 - r2);
            long diff2 = diff * diff;                // (|r1-r2|)^2

            // case 1: 완전 겹침
            if (dist2 == 0 && r1 == r2) {
                sb.append(-1).append('\n');
            }
            // case 2: 너무 멀어서 안 만남
            else if (dist2 > sum2) {
                sb.append(0).append('\n');
            }
            // case 3: 바깥에서 한 점 접함
            else if (dist2 == sum2) {
                sb.append(1).append('\n');
            }
            // case 4: 안에 있는데 안 닿음
            else if (dist2 < diff2) {
                sb.append(0).append('\n');
            }
            // case 5: 안에서 한 점 접함
            else if (dist2 == diff2) {
                sb.append(1).append('\n');
            }
            // case 6: 두 점에서 만남
            else {
                sb.append(2).append('\n');
            }
        }

        System.out.print(sb);
    }
}