class Solution {
    int[] numbers;
    int target;
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);
        return answer;
    }
    public void dfs(int idx, int sum){
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            } return;
        }
        int total1 = sum + numbers[idx];
        int total2 = sum - numbers[idx];
        
        dfs(idx+1,total1);
        dfs(idx+1,total2);    
    }
}