import java.util.*;

class Solution {
  public int[] solution(int[] numbers) {
        
        Set<Integer> aSet = new HashSet<Integer>();
        for(int i = 0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                aSet.add(numbers[i]+numbers[j]);   
            }    
        }
        int[] answer = new int[aSet.size()];
        int i = 0;
        for(int x : aSet){
            answer[i] = x;
            i++;
        }
        Arrays.sort(answer);
        return answer;
        
    }
}