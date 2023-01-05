class Solution {
    public int[] solution(long begin, long end) {
        int len = (int)(end-begin+1);
        int[] answer = new int[len];
        int idx = 0;
        for(int i= (int)begin; i<=(int)end; i++){
            //i의 가장 큰 소수값
            //본인이 최소 약수값이면 1
            answer[idx++] = maxDivisor(i);
        }
        if(begin == 1){
            answer[0] = 0;
        }
        return answer;
    }
    public int maxDivisor(int n){
        for(int i=2; i<=Math.sqrt(n);i++){
            if(n%i == 0){
                if(n/i > 10000000){
                    continue;
                }
                return n/i; // 최대값
            }
        }
        return 1; //나누어 떨어지지 않으면 n 반환 
    }
}