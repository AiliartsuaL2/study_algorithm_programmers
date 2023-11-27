import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        // n개의 기둥을 1번부터 3번까지 이동
        recursion(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
    
    private void recursion(int n, int from, int to, List<int[]> proccess) {
        // 종료조건 
        // 1일때는 from에서 to로 이동
        if(n == 1) {
            proccess.add(new int[] {from, to});
            return;
        }
        
        // 비어있는 기둥 , 1번 2번 3번의 합에서 이동한 기둥을 빼주면 된다.
        int empty = 6 - from - to;
        
        // 점화식 
        //  1. n-1개의 원판을 from이나 to가 아닌 빈 기둥으로 옮긴다.
        //  2. 하나의 원판을 from기둥에서 to기둥으로 옮긴다.
        //  3. n-1개의 원판을 빈 기둥에서 to 기둥으로 옮긴다.
        // pseudo code
        // (n, from, to) = 1번 (n-1, from, empty) + 2번 (1, from, to) + 3번(n-1, empty, to)
        // proccess.addAll(recursion(n-1, from, empty));
        // proccess.addAll(recursion(1, from, to));
        // proccess.addAll(recursion(n-1, empty, to));
        
        // 최적화 - 매개변수에 결과를 더해주는 방식
        recursion(n-1, from, empty, proccess);
        recursion(1, from, to, proccess);
        recursion(n-1, empty, to, proccess);
    }
}