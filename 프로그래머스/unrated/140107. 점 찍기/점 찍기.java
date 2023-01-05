class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0; i<=d; i+=k){
            long xx = (long) Math.pow(i, 2);
            long dd = (long) Math.pow(d, 2);
            int result = (int)(Math.sqrt(dd-xx));
            
            answer += yPossibleCount(result,k);
        }
        
        return answer;
    }    
    private static int yPossibleCount(int possible, int k){
        int y = (possible/k);
        return y+1;
    }
}