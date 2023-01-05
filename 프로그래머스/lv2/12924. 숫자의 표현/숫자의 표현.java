class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n%2 == 0){ //짝수
            while(n%2 == 0 && n > 1){
                n/=2;
            }
            if(n==1){
                answer = 1;
            }
            answer = primeNum(n);
        }
        else{ // 홀수
            answer = primeNum(n);
        }
        
        return answer;
    }
    public int primeNum(int num){
        int cnt = 1;
        for(int i=1; i<num; i++){
            if(num % i == 0){
                cnt++;
            }
        }
        return cnt;
    }
}