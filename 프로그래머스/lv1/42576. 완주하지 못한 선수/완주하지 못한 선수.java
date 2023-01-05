import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> aMap = new HashMap<>();        
        
        for(int i=0; i<participant.length; i++){
            String name = participant[i];
            if(aMap.containsKey(name)){
                int count = aMap.get(name);
                aMap.put(name,++count);                 
            }
            else{
                aMap.put(name,1);
            }
        }    
        for(int i =0; i<completion.length; i++){
            String name = completion[i];
            int count = aMap.get(name);
            if(count == 1){
                aMap.remove(name);
            }
            else{
                aMap.put(name,--count);
            }
        }
        String tmp = aMap.keySet().toString();
        answer = tmp.substring(1,tmp.length()-1);
        return answer;
    }
}