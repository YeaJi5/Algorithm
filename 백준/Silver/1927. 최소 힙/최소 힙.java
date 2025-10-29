import java.util.*;
import java.io.*;

// 최소 힙
// 1. 배열에 자연수 x를 넣는다.
// 2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거

public class Main {
	public static void main(String[] args)throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			
			if (num==0) {
				if(pq.isEmpty()) {
					sb.append(num).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.offer(num);
			}
			
		}
		
		System.out.println(sb);
		
	}
}
