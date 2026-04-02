package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_10825 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Student[] students = new Student[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			students[i] = new Student(st.nextToken(), 
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(students, Comparator.comparingInt((Student s) -> -s.getKor())
										.thenComparingInt(Student::getEng)
										.thenComparingInt((Student s) -> -s.getMath())
										.thenComparing(Student::getName)
					);
		StringBuilder sb = new StringBuilder();
		for(Student s: students) {
			sb.append(s.getName()).append("\n");
		}
		System.out.print(sb);
	}

	static class Student {
		private String name;
		private int kor, eng, math;

		Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		public String getName() {
			return name;
		}
		
		public int getKor() {
			return kor;
		}
		
		public int getMath() {
			return math;
		}
		
		public int getEng() {
			return eng;
		}
	}
}
