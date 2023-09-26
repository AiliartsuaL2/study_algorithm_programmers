import java.lang.StringBuilder;
class Solution {
    public int[] solution(long n) {
        String nStr = String.valueOf(n);
        StringBuilder sb = new StringBuilder(nStr);
        
        sb.reverse();
        
        String[] nArr = sb.toString().split("");
        int[] answer = new int[nArr.length];
        for(int i=0; i<nArr.length; i++){
            // System.out.println(nArr[i]);
            answer[i] = Integer.parseInt(nArr[i]);
        }
        
        return answer;
    }
}