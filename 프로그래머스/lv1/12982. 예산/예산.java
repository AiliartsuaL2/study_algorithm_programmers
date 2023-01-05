import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        // ArrayList<Integer> aList = new ArrayList<>();
        // for(int i = 0; i<d.length; i++){
        //     aList.add(d[i]);
        // }
        // Arrays.sort(aList);
        // Iterator<Integer> iterator = aList.iterator();
        // int sum = 0;
        // while(iterator.hasNext()){
        //     sum+=iterator.next();
        //     answer ++;
        //     if(sum > budget){
        //         break;
        //     }
        // }
        Arrays.sort(d);
        int sum = 0;
        for(int i = 0; i<d.length; i++){
            sum += d[i];
            if(sum > budget){
                break;
            }
            answer ++;
        }
        return answer;
    }
}