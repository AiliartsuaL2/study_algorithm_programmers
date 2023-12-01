import java.util.Collections;
import java.util.Arrays;

class Solution {
    int[] array;
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        this.array = array;
        int index = 0;
        for(int[] command : commands) {
            // 배열은 0번부터 시작
            int from = command[0] - 1;
            int to = command[1];
            // 배열은 0번부터 시작 
            int k = command[2] - 1;
            answer[index++] = getNumber(from, to, k);
        }
        return answer;
    }
    private int getNumber(int from, int to, int k) {
        int[] numbers = Arrays.copyOfRange(array, from, to);
        Arrays.sort(numbers);
        return numbers[k];
    }    
}