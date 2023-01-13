import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> tanMap = new HashMap<>(); 
        for(int tan : tangerine){
            tanMap.put(tan,tanMap.getOrDefault(tan,0)+1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(tanMap.entrySet());    
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
	        return o2.getValue() - o1.getValue();
            }
        });
        for(Map.Entry<Integer,Integer> map : entryList){
            answer ++;
            k -= map.getValue();
            if(k <= 0)
                break;
        }
        
        return answer;
    }
}