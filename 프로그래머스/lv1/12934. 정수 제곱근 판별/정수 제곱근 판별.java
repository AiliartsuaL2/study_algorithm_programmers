class Solution {
    public long solution(long n) {
        long answer = 0;
        if(Math.pow((int) Math.sqrt(n),2) == n ){
            answer = (long) Math.pow((int) Math.sqrt(n)+1,2);
            return answer;        
        }
        return -1;
    }
}