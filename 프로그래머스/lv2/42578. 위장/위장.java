import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String,ArrayList<String>> clothMap = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String color = clothes[i][0];
            String kind = clothes[i][1];
            ArrayList<String> arr = clothMap.getOrDefault(kind,new ArrayList<>());
            arr.add(color);
            clothMap.put(kind,arr);
        }
        
        if(clothMap.keySet().size() == 1){
            for(String key : clothMap.keySet()){
                return clothMap.get(key).size();
            }
        }
        
        int cnt = 1;
        for(String key : clothMap.keySet()){
            cnt *= clothMap.get(key).size() + 1; // 모든 경우의 수
        }
        answer = cnt -1 ;
        return answer;
    }
}