import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 0;
        num = (int)(Math.log10(n)+1);
        for(int i=1; i<=num; i++){
            int a = 0;
            int b = 0;
            a = (int) (Math.pow(10,i));
            b = (int) (Math.pow(10,i-1));
            if(i == 1){
               answer += n % a;
            }
            else{
                answer += ((n % a) - (n % b))/ b ;    
            }
        }
        return answer;
    }
}