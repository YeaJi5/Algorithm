import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String word;
		int cnt=0;
		for (int i=0; i<N; i++) {
			word = br.readLine();
			
			if (checkWord(word)) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}
	
	public static boolean checkWord(String word) {
		char prevWord = word.charAt(0);;
		boolean[] seen = new boolean[26]; 
		seen[prevWord - 'a'] = true;
		for (int i=0; i<word.length(); i++) {
			if (prevWord != word.charAt(i)) {
				if (seen[word.charAt(i)-'a']) {
					return false;
				}else {
					seen[word.charAt(i)-'a']=true;
					prevWord = word.charAt(i);
				}
			}
		}
		return true;
	}
}
