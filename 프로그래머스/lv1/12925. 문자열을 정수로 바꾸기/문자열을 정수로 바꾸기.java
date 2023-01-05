class Solution {
    public int solution(String s) {
        int answer = 0;
        char pm = s.charAt(0);
        int slen = s.length();
        if(pm == '+' || pm == '-'){
            answer = Integer.parseInt(s.substring(1,slen));
            if(pm == '-'){
                answer = answer * (-1);
            }
        }
        else{
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}