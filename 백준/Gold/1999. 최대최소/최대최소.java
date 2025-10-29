import java.util.*;
import java.io.*;

public class Main {
	static int N, B, K;
	static int[][] num;
	
	// 미리 구해서 배열에 저장해놓자
	static int[][] maxArr;
	static int[][] minArr;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		num = new int[N][N];
		
		int newSize = N-B+1;
		maxArr = new int[newSize][newSize];
		minArr = new int[newSize][newSize];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 여기서 최대 최소 미리 찾아서 저장해놓기
		partArr();
//		printArr();
		
		// 질문
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int ni = Integer.parseInt(st.nextToken());
			int nj = Integer.parseInt(st.nextToken());
			
			sb.append(maxArr[ni-1][nj-1]-minArr[ni-1][nj-1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void partArr() {
		for(int i=0; i<N-B+1; i++) {
			for(int j=0; j<N-B+1; j++) {
				int maxV = num[i][j];
				int minV = num[i][j];
				for(int k=i; k<i+B; k++) {
					for(int l=j; l<j+B; l++) {
						maxV = Math.max(maxV, num[k][l]);
						minV = Math.min(minV, num[k][l]);
					}
				}
				maxArr[i][j] = maxV;
				minArr[i][j] = minV;
				
			}
		}
	}
	
	public static void printArr() {
		System.out.println();
		for(int i=0; i<N-B+1; i++) {
			for(int j=0; j<N-B+1; j++) {
				System.out.print(maxArr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i<N-B+1; i++) {
			for(int j=0; j<N-B+1; j++) {
				System.out.print(minArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
