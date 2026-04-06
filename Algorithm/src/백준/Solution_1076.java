package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution_1076 {
	static String[] color = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
	static Map<String, Integer> map = new HashMap<>();
	static {
		for (int i = 0; i < color.length; i++) {
			map.put(color[i], i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();
		String third = br.readLine();
		// powTable 사용하는 방법도 있음
		long result = (map.get(first) * 10 + map.get(second)) * (long) Math.pow(10, map.get(third));
		System.out.println(result);
	}
}
