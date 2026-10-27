package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 실수의이진수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float number = Float.parseFloat(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(decimalToBinary(number));
        System.out.println(sb.toString());
    }

    public static String decimalToBinary(float num) {
        StringBuilder sb = new StringBuilder();
        int natural = (int) num;
        if (natural == 0) {
            sb.append(0);
        } else {
            while (0 < natural) {
                sb.insert(0, natural % 2);
                natural /= 2;
            }
        }
        sb.append(".");
        int cnt = 0;
        float decimal = num - (int) num;
        while (decimal != 1 && cnt < 4) {
            float value = decimal * 2;
            sb.append((int) value);
            cnt++;
            decimal = value - (int) value;
        }
        return sb.toString();
    }
}
