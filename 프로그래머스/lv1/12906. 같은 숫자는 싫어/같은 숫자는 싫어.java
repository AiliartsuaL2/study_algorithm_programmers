import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }
    /*
    public int[] solution(int []arr) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        int x = 10;
        for(int i=0; i<arr.length; i++){
            if(!(arr[i] == x)){
            aList.add(arr[i]);
            x = arr[i];
            }
        }
        int[] answer = new int[aList.size()];
        Iterator<Integer> iterator = aList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            answer[i] = iterator.next();
            i++;
        }
        return answer;
    }*/
}