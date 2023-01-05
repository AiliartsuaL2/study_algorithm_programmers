class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int tmp = 0;
        for(int i =0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    tmp = nums[i] + nums[j] + nums[k];
                    int flag = 0;
                    for(int x = 1; x<=(int)Math.sqrt(tmp); x++){
                        if(tmp % x == 0){
                            flag ++;
                        } 
                    }
                    if(flag == 1){
                        answer ++;
                    }
                }
            }
        }
        return answer;
    }
}