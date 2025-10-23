import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int current = 1; // 다음에 push할 숫자
        boolean possible = true;

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            // target까지 push
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            // 스택의 top이 target과 같으면 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 만들 수 없는 수열
                possible = false;
                break;
            }
        }

        if (!possible) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
