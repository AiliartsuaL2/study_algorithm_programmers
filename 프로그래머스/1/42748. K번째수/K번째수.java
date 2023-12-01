import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] array;
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        this.array = array;
        int index = 0;
        for(int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            answer[index++] = getNumber(i, j, k);
        }
        return answer;
    }
    private int getNumber(int i, int j, int k) {
        List<Integer> numbers = new ArrayList<>();
        for(int a = i-1; a < j; a++) {
            numbers.add(array[a]);
        }
        Collections.sort(numbers);
        
        return numbers.get(k-1);
    }    
}