import java.io.*;
import java.util.*;

public class Main {
	static int set = 0;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String command;
		int num;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if (st.countTokens()==1) {
				command = st.nextToken();
				num = 0;
			}else {
				command = st.nextToken();
				num = Integer.parseInt(st.nextToken());
			}
			
			int result = calc(command, num);
			
			if (result!=-1) {
				sb.append(result).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static int calc(String command, int num) {
		if (command.equals("add")) {
			set |= (1<<num);
		}else if(command.equals("remove")) {
			// num번째 인덱스만 0
			set &= ~(1<<num);
		}else if(command.equals("check")) {
			if((set&(1<<num))==(1<<num)) {
				return 1;
			}else return 0;
		}else if(command.equals("toggle")) {
			set ^= (1<<num);
		}else if(command.equals("all")) {
			set |= ((1<<21)-1);
		}else {
			set &= 0;
		}
		return -1;
	}
}
