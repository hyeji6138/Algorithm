package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자삼각형2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 0 || !(1 <= N && N <= 100)) { // 짝수거나 범위를 벗어나면
            System.out.print("INPUT ERROR");
        } else {
            int totalCnt = (N / 2) * (N / 2) + N - 1;
            char[][] values = new char[N][N];
            for (int j = 0, cnt = 0; j < N; j++) {
                for (int i = N - 1 - j; i >= j; i--) {
                    values[i][j] = (char) ('A' + (totalCnt - cnt++) % 26);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!Character.isAlphabetic(values[i][j])) {
                        continue;
                    }
                    sb.append(values[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }
}
