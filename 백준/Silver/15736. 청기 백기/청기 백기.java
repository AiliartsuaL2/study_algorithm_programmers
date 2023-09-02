
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        /**
         * 제곱이 되는 수만 체크해주면 됨 (홀수번 변경해야하기 때문에)
         * +1을 해줌(1번은 항상 위를보고있음)
         */

        Double sqrt = Math.sqrt(n);
        System.out.println(sqrt.intValue());

    }
}