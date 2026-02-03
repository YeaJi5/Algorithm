import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long V = Long.parseLong(st.nextToken());

        long upPerDay = A - B;
        long remaining = V - A; // 마지막 날 올라갈 A를 빼고 남은 높이

        long day;
        if (remaining <= 0) {
            day = 1; // 첫날에 바로 도착 가능
        } else {
            day = (remaining + upPerDay - 1) / upPerDay + 1; // 올림 + 마지막날
        }

        System.out.println(day);
    }
}
