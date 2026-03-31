package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		User[] users = new User[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			users[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(users, Comparator.comparingInt(User::getAge));
		StringBuilder sb = new StringBuilder();
		for (User u : users) {
			sb.append(u).append("\n");
		}
		System.out.print(sb);
	}

	public static class User {
		private int age;
		private String name;

		User(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public String toString() {
			return age + " " + name;
		}

		public int getAge() {
			return age;
		}

		public String getName() {
			return name;
		}
	}
}
