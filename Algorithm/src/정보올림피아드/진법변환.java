package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진법변환 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] input = br.readLine().split(" ");
            if (input.length == 1 && input[0].equals("0")) {
                break;
            }
            int B = Integer.parseInt(input[0]);
            int nextB = Integer.parseInt(input[2]);
            long num = 0;
            for (int i = 0; i < input[1].length(); i++) {
                int point = 0;
                if (Character.isAlphabetic(input[1].charAt(i))) {
                    point = input[1].charAt(i) - 'A' + 10;
                } else {
                    point = input[1].charAt(i) - '0';
                }
                if (0 < point) {
                    long pv = 1;
                    for (int j = 0; j < input[1].length() - 1 - i; j++) {
                        pv *= B;
                    }
                    num += pv * point;
                }
            }
            if (num == 0) {
                sb.append("0\n");
            } else {
                StringBuilder nextNum = new StringBuilder();
                while (num > 0) {
                    long remainder = num % nextB;
                    if (remainder >= 10) {
                        nextNum.insert(0, (char) ('A' + remainder - 10));
                    } else {
                        nextNum.insert(0, remainder);
                    }
                    num /= nextB;
                }
                sb.append(nextNum.toString()).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
