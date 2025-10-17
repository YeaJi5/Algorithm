import java.util.*;
import java.io.*;

// for문 돌리기 -> 시간초과
// stack 사용해보기

public class Main {
	static int N;
	static Stack<Coord> stack = new Stack<>();
	
	static class Coord{
		int num, h;
		public Coord(int num, int h) {
			this.num = num;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			int h = Integer.parseInt(st.nextToken());
			sb.append(checkH(h)).append(" ");
			stack.push(new Coord(i, h));
		}
		
		System.out.println(sb);
	}
	
	public static int checkH(int h){
		while (!stack.isEmpty()) {
			Coord cur = stack.peek();
			if (cur.h > h) {
				return cur.num;
			}else {
				stack.pop();
			}
		}
		return 0;
	}
}