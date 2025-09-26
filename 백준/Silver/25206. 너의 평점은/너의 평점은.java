import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 20;
		String subject;
		float t;
		String score;
		
		float sumScore = 0;
		float sumSubject = 0;
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			subject = st.nextToken();
			t = Float.parseFloat(st.nextToken());
			score = st.nextToken();
			
			float s=0;
			if (score.equals("A+")) {
				s = 4.5f;
			}else if(score.equals("A0")) {
				s = 4.0f;
			}else if(score.equals("B+")) {
				s = 3.5f;
			}else if(score.equals("B0")) {
				s = 3.0f;
			}else if(score.equals("C+")) {
				s = 2.5f;
			}else if(score.equals("C0")) {
				s = 2.0f;
			}else if(score.equals("D+")) {
				s = 1.5f;
			}else if(score.equals("D0")) {
				s = 1.0f;
			}else if(score.equals("F")){
				s = 0.0f;
			}else if(score.equals("P")) {
				continue;
			}
			sumSubject += t;
			sumScore += (s*t);
		}
		
		System.out.println(sumScore/sumSubject);
	}
}
