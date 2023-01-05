class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
       if(((a < b && a % 2 == 1) && (b == a+1)) || ((a > b && b % 2 == 1) && (a == b+1))){
        }
        else{

        while(n>0){
            if(a % 2 == 0){ // a 짝수 일 떄
                a/=2;
            }else{ // a 홀수 일 때
                a = (a/2)+1;
            }
            if(b % 2 == 0){ // b 짝수 일 떄 
               b/=2;
            }else{// b 홀수 일 때
               b = (b/2)+1;
            }
            if(((a < b && a % 2 == 1) && (b == a+1)) || ((a > b && b % 2 == 1) && (a == b+1))){
                answer++;
                break;    
            }
            else{
                answer++;
                n/=2;
            }
        }
        }
        return answer;
    }
}