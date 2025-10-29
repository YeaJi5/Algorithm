import java.util.*;
import java.io.*;

// 최대힙
// 1. 배열에 자연수 x를 넣는다.
// 2. 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거

public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 최대힙
		PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			Long num = Long.parseLong(br.readLine());
			
			if (num==0) {
				if(maxHeap.isEmpty()) sb.append(num).append("\n");
				else sb.append(maxHeap.poll()).append("\n");
			}else {
				maxHeap.offer(num);
			}
		}
		
		System.out.println(sb);
	}
}
