class Solution {
    public String solution(String s, int n) {
        String answer = "";
            
        for(int i=0; i<s.length(); i++){
         int tmp = (int) s.charAt(i) + n;
        if((int) s.charAt(i) == 32){
            answer += " ";
            continue;
        }
        if((int)s.charAt(i) < 91){ 
            if(tmp > 90){
                tmp = tmp-26;
                } 
            }
        else{
            if(tmp > 122){
                tmp = tmp-26;
                }
            }
         answer+=String.valueOf((char) tmp);
        }
        return answer;
    }
}