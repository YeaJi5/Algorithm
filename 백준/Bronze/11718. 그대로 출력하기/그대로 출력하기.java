import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		while ((str = br.readLine()) != null) {
			sb.append(str).append("\n");
		}
		
		System.out.println(sb);
	}
}
