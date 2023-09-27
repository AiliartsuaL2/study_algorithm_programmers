import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int startIdx = 0;
        Map<String,Integer> map = new HashMap<String,Integer>(){
            {
                put("zero",0);
                put("one",1);
                put("two",2);
                put("three",3);
                put("four",4);
                put("five",5);
                put("six",6);
                put("seven",7);
                put("eight",8);
                put("nine",9);
            }
        };
        
        StringBuilder sb = new StringBuilder();
        for(int endIdx=0; endIdx< s.length(); endIdx++){
            // 숫자면 그대로 더하고, 다음 수부터 시작 
            if(Character.isDigit(s.charAt(endIdx))){
                sb.append(s.charAt(endIdx));
                startIdx = endIdx+1;
                continue;
            }
            // 아니면 알파벳 확인
            String numStr = s.substring(startIdx,endIdx+1);
            // 선언되어있는 단어가 아니면 넘어감
            int number = map.getOrDefault(numStr,-1);
            if(number == -1)
                continue;
            sb.append(number);
            startIdx = endIdx + 1;
        }
        answer = Integer.parseInt(sb.toString());
        
        return answer;
    }
}