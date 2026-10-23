package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] binaryN = br.readLine().toCharArray();
        int num = 0;
        for (int i = 0; i < binaryN.length; i++) {
            if (binaryN[i] == '1') {
                num += Math.pow(2, binaryN.length - 1 - i);
            }
        }
        System.out.print(num);
    }
}
