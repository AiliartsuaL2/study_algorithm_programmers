class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = 0;
        if(m>=n){
          max = m;
          }
        else{
          max = n;
          }
        if(m%n == 0){
            answer[0] = n;
            answer[1] = m;
        }
        else if(n%m == 0){
            answer[0] = m;
            answer[1] = n;
        }
        else{
            int i = 1;
            int x = 1;
            int y = 1;
            while(i<max){
             if(n%i==0 && m%i==0){
                 x *= i;
                 n /= i;
                 m /= i;
                 i=1;
             }   
                i++;
            }
            y = x*n*m;
            answer[0] = x;
            answer[1] = y;
        }
        
        return answer;
    }
}