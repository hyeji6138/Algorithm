package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구구단_1291 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int start, end;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			if (2 <= start && start <= 9 && 2 <= end && end <= 9) {
				break;
			}
			sb.append("INPUT ERROR!\n");
		}
		if (start < end) {
			for (int i = 1; i <= 9; i++) {
				for (int j = start; j <= end; j++) {
					sb.append(String.format("%d * %d = %2d", j, i, j*i));
					if(j != end) sb.append("   ");
				}
				sb.append("\n");
			}
		}else {
			for (int i = 1; i <= 9; i++) {
				for (int j = start; j >= end; j--) {
					sb.append(String.format("%d * %d = %2d", j, i, j*i));
					if(j != end) sb.append("   ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
