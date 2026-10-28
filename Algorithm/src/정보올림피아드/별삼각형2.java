package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별삼각형2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 1 || 100 < N || N % 2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = N / 2 + 1;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j <= cnt - 1 - i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = 1; i < cnt; i++) {
            for (int j = 0; j < cnt - 1; j++) {
                sb.append(" ");
            }
            for (int j = 0; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
