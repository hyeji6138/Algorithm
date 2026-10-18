package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구구단3_1341 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		if (a <= b) {
			for (int i = a; i <= b; i++) {
				for (int j = 1; j <= 9; j++) {
					sb.append(String.format("%d * %d = %2d", i, j, i * j));
					if (j % 3 == 0) {
						sb.append("\n");
					} else {
						sb.append("   ");
					}
				}
				sb.append("\n");
			}
		} else {
			for (int i = a; i >= b; i--) {
				for (int j = 1; j <= 9; j++) {
					sb.append(String.format("%d * %d = %2d", i, j, i * j));
					if (j % 3 == 0) {
						sb.append("\n");
					} else {
						sb.append("   ");
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
