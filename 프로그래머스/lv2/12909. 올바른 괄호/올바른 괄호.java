import java.util.Stack;
class Solution {
    boolean solution(String s) {

        Stack<Character> sStack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp == '('){
                sStack.push(tmp);
            }
            else{
                if(sStack.isEmpty()){
                    return false;
                }
                sStack.pop();
            }
        }
        if(!sStack.isEmpty()){
            return false;
        }
        return true;
    }
}