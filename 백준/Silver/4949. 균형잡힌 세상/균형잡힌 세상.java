import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String str = br.readLine();
			
			if (str.length()==1 && str.equals(".")) {
				break;
			}
			
			sb.append(check(str)).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	public static String check(String str) {
		Stack <Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if (c=='(' || c=='[') {
				stack.add(c);
			} 
			
			else if(c==')') {
				// 스택이 비어 있으면
				if (stack.isEmpty()) return "no";
				// 스택이 비어있지 않다면
				else {
					char top = stack.pop();
					if (top != '(') return "no";
				}
			}
			
			else if(c==']') {
				// 스택이 비어 있으면
				if (stack.isEmpty()) return "no";
				// 스택이 비어있지 않다면
				else {
					char top = stack.pop();
					if (top != '[') return "no";
				}
			}
		}
		
		if (!stack.isEmpty()) return "no";
		
		
		return "yes";
	}
}
