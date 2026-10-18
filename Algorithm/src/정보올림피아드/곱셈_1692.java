package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셈_1692 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append(a * (b % 10)).append("\n");
		sb.append(a * ((b / 10) % 10)).append("\n");
		sb.append(a * (b / 100)).append("\n");
		sb.append(a * b);
		System.out.print(sb.toString());
	}
}
