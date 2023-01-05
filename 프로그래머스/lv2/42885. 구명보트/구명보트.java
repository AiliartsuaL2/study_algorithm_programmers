import java.util.*;

class Solution {
        public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for(int x : people) list.add(x);
        
        Collections.sort(list);

        ArrayDeque<Integer> dq = new ArrayDeque<>(50000);
        
        for(int x : list) dq.add(x);

        while(dq.isEmpty() == false) {
            int weight = dq.pollLast();
            if(dq.isEmpty() == false && weight + dq.peekFirst() <= limit) {
                dq.pollFirst(); 
            }
            answer++;
        }
        return answer;
    }
}