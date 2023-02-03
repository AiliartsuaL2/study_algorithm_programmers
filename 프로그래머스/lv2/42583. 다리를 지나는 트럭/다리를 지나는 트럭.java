import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int time = 0;
        // 다리오를때 시간추가

        Queue<Integer> bridgeQ = new LinkedList<>();
        for(int truck : truck_weights){
            while(true){
                if(bridgeQ.isEmpty()){ // 다리에 트럭이 하나도 없는 경우
                    bridgeQ.offer(truck);
                    sum += truck;
                    time++;
                    break;
                }
                else if(bridgeQ.size()==bridge_length){ //다리에 트럭의 개수만큼 꽉 찬 경우                    
                    sum -= bridgeQ.poll(); // 첫번째 들어가있는 트럭만 지나가게 함
                }
                else{ // 다리 길이만큼 큐가 차지않았을경우
                    if(sum+truck <= weight){ // 무게 안쪽인경우
                        bridgeQ.offer(truck);
                        sum+=truck;
                        time++;
                        break;
                    }else{ // 무게보다 무거울경우
                        bridgeQ.offer(0); // 0을넣어서 사이즈를 키워서 트럭을 보내게만듬
                        time++;
                    }
                }
            }
        }
         // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야하기에 + 다리 길이 
        answer = time + bridge_length; 
        return answer;
    }
}