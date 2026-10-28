package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별삼각형3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 1 || N > 100 || N % 2 == 0) {
            System.out.print("INPUT ERROR!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N / 2 + 1; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = N / 2 - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
