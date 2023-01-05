import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int x = 0; x<commands.length; x++){
            int a = 0;
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            int[] tmp = new int[j-i+1]; 
            for(int y = i-1; y<j; y++){
                tmp[a] = array[y];
                a++;
            }
            Arrays.sort(tmp);
            answer[x] = tmp[k-1];
        }
        return answer;
    }
}