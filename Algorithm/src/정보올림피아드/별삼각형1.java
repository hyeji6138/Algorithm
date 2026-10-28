package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별삼각형1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), type = Integer.parseInt(input[1]);
        if (N < 1 || 100 < N) {
            System.out.println("INPUT ERROR!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        switch (type) {
            case 1:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j <= i; j++) {
                        sb.append("*");
                    }
                    sb.append("\n");
                }
                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - i; j++) {
                        sb.append("*");
                    }
                    sb.append("\n");
                }
                break;
            case 3:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - 1 - i; j++) {
                        sb.append(" ");
                    }
                    for (int j = 0; j < i * 2 + 1; j++) {
                        sb.append("*");
                    }
                    sb.append("\n");
                }
                break;
            default:
                sb.append("INPUT ERROR!");
        }
        System.out.print(sb.toString());
    }
}
