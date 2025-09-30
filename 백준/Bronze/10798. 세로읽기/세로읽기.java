import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char [][] str = new char [5][15];
		
		for (int i=0; i<5; i++) {
			Arrays.fill(str[i], '!');
		}
		
		for (int i=0; i<5; i++) {
			String s = br.readLine();
			for (int j=0; j < s.length(); j++) {
				str[i][j] = s.charAt(j);
			}
		}
		
		for (int j=0; j<15; j++) {
			for (int i=0; i<5; i++) {
				if (str[i][j] != '!') {
					sb.append(str[i][j]);
				}
			}
		}
		
		System.out.println(sb);
	}

}
