import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int k=0; k<s.length(); k++){
            if(k != 0){
                String tmp = sb.substring(0,1);
                sb.deleteCharAt(0);
                sb.append(tmp);
            }
            String sbStr = sb.toString();
            Stack<Character> bracketStack = new Stack<>();
            for(int i=0; i<sbStr.length(); i++){
                if(!bracketStack.isEmpty()){
                    if(sbStr.charAt(i) == ']' && bracketStack.peek() =='[')
                        bracketStack.pop();
                    
                    else if(sbStr.charAt(i) == ')' && bracketStack.peek() =='(')
                        bracketStack.pop();
                    
                    else if(sbStr.charAt(i) == '}' && bracketStack.peek() =='{')
                        bracketStack.pop();
                    
                    else bracketStack.push(sbStr.charAt(i));
                }
                else{
                    bracketStack.push(sbStr.charAt(i));
                }
            }
            if(bracketStack.isEmpty()){
                answer ++;
            }
        }
        return answer;
    }
}