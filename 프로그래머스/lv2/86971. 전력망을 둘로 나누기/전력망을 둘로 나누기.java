import java.util.Queue;
import java.util.LinkedList;

// 인접행렬에 그래프를 표현하고,
// for문을 돌면서 선을 하나씩 끊어보고 나누어진 두 전력망의 송전탑 개수 차이를 구한다..
    // 선 하나를 끊는다.
    // bfs를 이용하여 끊어진 선의 두 노드 중, 하나를 선택하여 연결된 송전탑의 개수를 구함.(cnt)
        // 두 전력망은 각각 cnt개, n-cnt개의 송전탑이 있음
        // Math.abs(n-2*cnt) : 두 전력망이 갖고있는 송전탑의 개수의 차이
        // 최솟값을 answer에 갱신
    // 선을 다시 복구시킴
class Solution {
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n+1][n+1];
        for(int i=0; i<wires.length; i++){ // 인접 행렬에 input
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        //선을 하나씩 끊어보면서 순회한다.
        int a,b;
        for(int i=0; i<wires.length; i++){
            a = wires[i][0];
            b = wires[i][1];
            
            arr[a][b] = 0; // 선을 하나씩 끊는다.
            arr[b][a] = 0;
            
            answer = Math.min(answer,bfs(n,a));// bfs시켜서 최솟값과 기존값을 비교
            
            arr[a][b] = 1;
            arr[b][a] = 1; // 선을 복구시킨다.
        }
        return answer;
    }
    public int bfs(int n, int start){
        int[] visit = new int[n+1];
        int cnt = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int point = queue.poll();
            visit[point] = 1;
            
            for(int i=1; i<=n; i++){
                if(visit[i] == 1){
                    continue;
                }
                if(arr[point][i]==1){
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n-2*cnt);
    }
}