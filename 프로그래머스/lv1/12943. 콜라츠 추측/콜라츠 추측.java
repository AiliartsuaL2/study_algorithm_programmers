class Solution {
    public int solution(int num) {
        int answer = 0;
        if(num == 1){
            answer = 0;
            return answer;
        }
        for(int i=0; i<500; i++){
            answer ++;
            if(num % 2 == 0){
                num = num/2;
                if(num == 1){
                    break;
                }
                continue;
            }
            if(num % 2 == 1){
                num = (num * 3) + 1;
                if(num == 1){
                    break;
                }
                continue;
            }
            if(i == 499){
                answer = -1;
                }
            }
        return answer;
    }
}