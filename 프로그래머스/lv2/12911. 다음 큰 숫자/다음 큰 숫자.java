import java.util.*;
class Solution {
    public int decimalToBinaryNum(int n){
        int n_count = 0;
        while(n>0){
            int bin = n%2;
            if(bin==0){
                }
            else{
                n_count++;
            }
            n/=2;
        }
        return n_count;
    }
    public int solution(int n) {
            int answer = 0;
            for(int i=n+1; i<n+10; i++){
                if(decimalToBinaryNum(n) == decimalToBinaryNum(i)){
                    answer = i;
                    break;
                }
            }
        return answer;
    }
}