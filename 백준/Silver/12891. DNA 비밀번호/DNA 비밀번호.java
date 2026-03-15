import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static int idx(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }

    public static boolean check(int[] part, int[] cor) {
        for (int i = 0; i < 4; i++) {
            if (part[i] < cor[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        int[] cor = new int[4];
        int[] part = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cor[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 구간 세기
        for (int i = 0; i < P; i++) {
            part[idx(str.charAt(i))]++;
        }

        int result = 0;
        if (check(part, cor)) {
            result++;
        }

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            part[idx(str.charAt(i - P))]--; // 앞 문자 제거
            part[idx(str.charAt(i))]++;     // 뒤 문자 추가

            if (check(part, cor)) {
                result++;
            }
        }

        System.out.println(result);
    }
}