import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer>boxQueue = new LinkedList<>();
        for(int i=1; i<=order.length; i++){
            boxQueue.offer(i);
        }
        
        Stack<Integer> tmpStack = new Stack<>(); 
        
        //박스들이 1번부터 들어오는걸 보면서
        // Order표랑 매칭을해서
        // 아니면 스택 peek 해서 확인하고 아니면 적재를 한다.
        // 아니면 임시보관함에(stack형태) 넣고
        // 맞으면 answer 증가시키고 queue값을 빼고 
        // 매칭 다해서 스택 확인하면서 맞으면 증가
        int orderIdx = 0;
        while(boxQueue.size()>0){
            if(orderIdx >= order.length){ // 탐색이 끝난경우
                break;
            }
            int boxOrder = order[orderIdx]; // 순서를 먼저보고
            
            int box = boxQueue.peek(); // 컨테이너벨트를 본다.
            
            if(box != boxOrder){ // 컨테이너값이랑 다르면
                if(!tmpStack.isEmpty()){
                    if(boxOrder == tmpStack.peek()){ // 스택을 확인해보고 맞는 상자면
                        tmpStack.pop();  // 상자를 빼서 트럭에 싣고
                        answer++;
                        orderIdx++;
                    }
                    else{ // 상자가 아니라면
                        boxQueue.poll(); // 본 벨트에있는 거를
                        tmpStack.push(box); // 임시 벨트에 넣는다.  
                    }
                }
                else{ // 임시 벨트가 비어있으면
                    boxQueue.poll(); // 본 벨트에있는 거를
                    tmpStack.push(box); // 임시 벨트에 넣는다.
                }
            }
            else{
                boxQueue.poll();
                answer++;
                orderIdx++;
            }
        }
        while(tmpStack.size()>0){
            if(orderIdx >= order.length){
                break;
            }
            if(tmpStack.peek()==order[orderIdx]){
                tmpStack.pop();
                answer++;
                orderIdx ++;
            }
            else{
                break;
            }
        }     
        return answer;
    }
}