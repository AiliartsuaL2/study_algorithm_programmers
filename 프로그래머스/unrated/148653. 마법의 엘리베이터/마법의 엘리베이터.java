class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey>0){
            int floor = storey%10;
            
            if(floor >= 6){
                storey += 10 - floor;
                answer += 10-floor;
            }
            else if(floor == 5 && (storey/10)%10 >= 5){
                storey += 10 - floor;
                answer += 10 - floor;
                
            }
            else{
                    answer += floor;
            }
            storey/=10;
        }
        return answer;
    }
}
