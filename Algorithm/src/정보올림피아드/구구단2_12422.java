package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구구단2_12422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			if (line.isEmpty()) { // 입력이 없을 때
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			if (a < 2 || 9 < a || b < 2 || 9 < b) { // 범위 밖일 떄
				sb.append("INPUT ERROR!\n");
			} else {
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
			}
		}
		System.out.println(sb.toString());
	}
}
