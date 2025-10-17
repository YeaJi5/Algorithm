import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
static int a, b, c, n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		System.out.println(check());
	}
	
	public static int check() {
		int cnt = n/a;
		while (cnt>=0) {
			int r = n-(a*cnt);
			if (r%b==0 || r%c==0) {
				return 1;
			}else {
				int cnt2 = r/b;
				while (cnt2>=0) {
					int r2 = r-(b*r);
					if (r2%c==0) {
						return 1;
					}
					cnt2--;
				}
			}
			cnt--;
		}
		
		return 0;
	}
}
