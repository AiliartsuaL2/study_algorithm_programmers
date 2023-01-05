import java.util.HashSet;
import java.util.LinkedList;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> numCase = new HashSet<>();
        // 1번 반복하는경우 > 1~5탐색
        for(int i=1; i<=elements.length;i++){ // 반복횟수 증가
            for(int j=0; j<elements.length; j++){ //시작 포인트 위치 증가
                int index = j;
                int sum = 0;
                for(int k=0; k<i; k++){
                    sum += elements[index];
                    index++;
                    if(index >= elements.length){
                         index = 0;
                    }
                } 
                numCase.add(sum);
            }
        }
        answer = numCase.size();
        
        return answer;
    }
}