package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String me = br.readLine();
		String doctor = br.readLine();

		if (doctor.length() <= me.length()) {
			System.out.println("go");
		} else {
			System.out.println("no");
		}
	}
}
