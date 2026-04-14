package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] quote = br.readLine().toCharArray(); // 입력 받기
		if (quote.length % 2 != 0) { // 괄호 짝이 맞지 않음
			System.out.println(0);
			return;
		}
		Deque<Integer> stack = new ArrayDeque<>();
		for (char ch : quote) {
			if (ch == '(') {
				stack.add(-1);
			} else if (ch == '[') {
				stack.add(-2);
			} else if (ch == ')') {
				int sum = 0;
				while (!stack.isEmpty() && 0 < stack.peek()) {
					sum += stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() == -1) { // () 짝 찾음
					stack.pop();
				} else {
					System.out.println(0);
					return;
				}
				// () 완료
				stack.add(sum == 0 ? 2 : 2 * sum);
			} else if (ch == ']') {
				int sum = 0;
				while (!stack.isEmpty() && 0 < stack.peek()) {
					sum += stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() == -2) { // [] 짝 찾음
					stack.pop();
				} else {
					System.out.println(0);
					return;
				}
				// [] 완료
				stack.add(sum == 0 ? 3 : 3 * sum);
			}
		}
		int answer = 0;
		while (!stack.isEmpty()) {
			if (stack.peek() < 0) { // 괄호 값이 있으면 실패
				answer = 0;
				break;
			}
			answer += stack.pop();
		}
		System.out.println(answer);
	}
}
