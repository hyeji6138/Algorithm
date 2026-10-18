package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 약수_2809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = (int) Math.sqrt(N); 0 < i ; i--) {
            if (N % i == 0) {
                sb.insert(0, String.format("%d ", i));
                if(i != Math.sqrt(N)){
                    sb.append(String.format("%d ", N/i));
                }
            }
        }
        System.out.println(sb.toString());
    }
}
