class Solution {
    static String answer;
    public String solution(String p) {
        answer = "";
        if(check(p))
            return p;
        answer = split(p);
        return answer;
    }
    public boolean check(String tmp){
        int gualhoCnt = 0;
        for(int i=0; i<tmp.length(); i++){
            String gualho = String.valueOf(tmp.charAt(i));
            if(gualho.equals("(")){
                gualhoCnt ++;
            }
            else{
                if(gualhoCnt <= 0){
                    return false;
                }
                gualhoCnt --;
            }
        }
        if(gualhoCnt != 0){
            return false;        
        }
        return true;
    }
    public String split(String w){
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        if(w.length() == 0) return ""; // 1단계, 빈문자열이면 빈 문자열 반환
        int open = 0;
        for(int i=0; i<w.length();i++){
            if(w.charAt(i) == '('){
                open++;
            }
            else{
                open--;
            }
            
            if(open == 0){ // 균형잡힌 괄호 문자열
                u.append(w.substring(0,i+1)); //해당 기점을 기준으로 나누어 넣어줌
                v.append(w.substring(i+1,w.length())); 
                
                if(check(u.toString())){//u가 올바른 괄호 문자열일경우
                    u.append(split(v.toString()));
                }
                else{ // u가 올바른 문자열이 아닐경우
                     StringBuilder str = new StringBuilder(); // 새 문자열을 생성해서
                     str.append("(");
                     str.append(split(v.toString())); // v를 재귀적으로 호출해서 붙임
                     str.append(")");
                     str.append(reverse(u.toString())); // 괄호 방향을 뒤집어서 붙임
                     return str.toString(); // 생성된 문자열 반환
                }
                break; // 재귀호출하고 break시킴 
            }
        }
        return u.toString(); 
    }
    public String reverse(String str){
        StringBuilder s = new StringBuilder();
        for(int i = 1; i<str.length()-1;i++){
            if(str.charAt(i) == '('){
                s.append(")");  
            } 
            else{
                s.append("(");  
            } 
        }
        return s.toString();
    }
}