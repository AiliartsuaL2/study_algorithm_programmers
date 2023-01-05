class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int index = 0;
        for(int i = 0; i<seoul.length; i++ ){
            if(seoul[i].equals("Kim")==true){
             break;   
            }
            index ++;
        }
        answer = "김서방은 ";
        answer += index;
        answer += "에 있다";
        return answer;
    }
}