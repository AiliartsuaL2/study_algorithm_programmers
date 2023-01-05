import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Map<Integer,Integer> qMap = new LinkedHashMap<>();
        
        int idx = 0;
        for(int i : priorities){
            qMap.put(idx++,i);
        }
        int cnt = 1;
        while(qMap.size()>0){
            Iterator<Integer> iter = qMap.keySet().iterator();
            
            int firstKey = iter.next();
            int j = qMap.get(firstKey);
            boolean bigBit = false;
            
            for(int key : qMap.keySet()){
                if(j < qMap.get(key)){ // 나머지 인쇄 대기목록에서 J보다 높은 문서가 하나라도 존재 시
                    qMap.remove(firstKey); // J를 제거 후
                    qMap.put(firstKey,j); // 다시 삽입(맨 뒤로)
                    bigBit = true;
                    break;
                }
            }
            
            if(bigBit == false){ // 그게 아니라면 J인쇄
                qMap.remove(firstKey);
                //몇번째 인지 검증로직
                if(firstKey == location){
                    answer = cnt;
                    break;
                }                
                cnt++;
            }
        }
        return answer;
    }
}