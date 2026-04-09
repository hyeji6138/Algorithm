package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		while ((input = br.readLine()) != null && !input.equals("0")) {
			String reversed = new StringBuilder(input).reverse().toString();
			sb.append(input.equals(reversed) ? "yes" : "no").append("\n");
		}
		System.out.print(sb);
	}
}
