class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;

        for(int j=1; j<= brown; j++){
            for(int i=1; i<= brown; i++){
                if(total == i*j){
                    if(i>=j){
                        if(yellow ==((i-2)*(j-2))){
                            answer[0] = i;
                            answer[1] = j;

                        }
                    }
                }
            }
        }

        return answer;
    }
}