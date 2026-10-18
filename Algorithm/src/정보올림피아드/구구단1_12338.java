package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구구단1_12338 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

		if (a <= b) {
			for (int i = a; i <= b; i++) {
				for (int j = 1; j <= 9; j++) {
					sb.append(String.format("%d * %d = %d\n", i, j, i * j));
				}
				sb.append("\n");
			}
		} else {
			for (int i = a; i >= b; i--) {
				for (int j = 1; j <= 9; j++) {
					sb.append(String.format("%d * %d = %d\n", i, j, i * j));
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
