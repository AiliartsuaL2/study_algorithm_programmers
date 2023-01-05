class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int count = 0;
        for(int i=1; i< 1000000000; i++){
            answer[i-1] = i*(long)x;
            count++;
            if(count == n){
                break;
            }
        }
        return answer;
    }
}