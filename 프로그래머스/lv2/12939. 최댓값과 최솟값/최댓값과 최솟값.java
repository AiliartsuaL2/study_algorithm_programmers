class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        int min = Integer.parseInt(sArr[0]);
        int max = Integer.parseInt(sArr[0]);
        for(int i=0; i<sArr.length; i++){
            int tmp = Integer.parseInt(sArr[i]);
            if(tmp < min){
                min = tmp;
            }
            if(tmp > max){
                max = tmp;
            }
        }
        answer += min;
        answer += " ";
        answer += max;
        
        return answer;
    }
}