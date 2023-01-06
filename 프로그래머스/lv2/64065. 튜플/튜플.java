import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.replaceAll("^[{]","");
        s = s.replaceAll("[}]$","");
        
        s = s.replaceAll("^[{]","");
        s = s.replaceAll("[}]$","");
        s = s.replace("},{","-");
        String[] sArr = s.split("-");
        
        Arrays.sort(sArr,(String s1, String s2) -> s1.length()-s2.length()); // 길이에 의한 정렬
        
        Set<String> numSet = new LinkedHashSet<>();
        
        for(String tmp : sArr){
            String[] tArr = tmp.split(",");
            for(String tm : tArr){
                numSet.add(tm);
            }
        }
        int[] answer = new int[numSet.size()];
        
        int idx = 0;
        for(String num : numSet){
            answer[idx++] = Integer.parseInt(num);
        }
        
        return answer;
    }
}