import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int a = arr[0]; // 더하기전에 탐색 후 추가를 해야함.
        for(int i =0; i<arr.length; i++){
            if(a >= arr[i]){
                a = arr[i];
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] == a){
                continue;
            }
            else{
                tmp.add(arr[i]);
            }
        }
        if(tmp.isEmpty()){
          tmp.add(-1);  
        }
        int[] answer = tmp.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}