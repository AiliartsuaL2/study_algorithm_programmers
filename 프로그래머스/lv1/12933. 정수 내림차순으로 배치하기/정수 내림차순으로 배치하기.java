import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] temp = String.valueOf(n).split("");
        int[] tempInt = new int[temp.length];
        for(int i=0;i<tempInt.length;i++){
            tempInt[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(tempInt);
        for(int i=0; i<tempInt.length; i++){
            answer += tempInt[i] * Math.pow(10,i);  
        }
        return answer;
    }
}