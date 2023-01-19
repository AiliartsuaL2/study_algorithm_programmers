import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville){
            pq.offer(scov);
        }
        while(true){
            if(pq.size() <= 1){
                if(pq.peek() < K){
                    answer = -1;
                }
                break;
            }
            if(pq.peek() < K){
                int min = pq.poll();
                int min2 = pq.poll();
                pq.offer(min+(min2*2));
                answer ++;
            }
            else{
                break;
            }
        }
        return answer;
    }
}