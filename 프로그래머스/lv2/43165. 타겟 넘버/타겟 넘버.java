class Solution {
    int target;
    int[] numbers;
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        recursion(0,0);
        
        return answer;
    }
    public void recursion(int idx,int nowValue){
        if(idx == numbers.length){
            if(nowValue == target){
                answer++;
            }
            return;
        }
        recursion(idx+1,nowValue+numbers[idx]);
        recursion(idx+1,nowValue-numbers[idx]);
    }    
}