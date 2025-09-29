import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = 9;
		int max_v = 0;
		int max_i = 0;
		int max_j = 0;
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (max_v < v) {
					max_v = v;
					max_i = i;
					max_j = j;
				}
				
			}
		}
		sb.append(max_v).append("\n").append(max_i+1).append(" ").append(max_j+1);
		System.out.println(sb);
	}
}
