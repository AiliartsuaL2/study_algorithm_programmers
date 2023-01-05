import java.util.*;
class Solution {
    
    static HashSet<Integer> primeSet = new HashSet<>();
    static LinkedList<String> numList = new LinkedList<>();
    static boolean[] visited; // 사용여부
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            numList.add(String.valueOf(numbers.charAt(i)));
        }
        
        dfs("",0);
        System.out.println(primeSet);
        answer = primeSet.size();
        return answer;
    }
    public void dfs(String str, int index ){
        int num = 0;
        if(str!=""){
            num = Integer.parseInt(str);
            if(isPrime(num)){
                primeSet.add(num); 
            } 
        }
        if(index==numList.size()){
            return; // 끝까지 다했을 때 
        } 
        
        for(int i=0;i<numList.size();i++){
            if(visited[i]){
                continue; // 방문한 노드면 넘어감
            } 
            visited[i] = true; // 방문
            
            dfs(str+numList.get(i), index+1); // 방문 했을 시 재귀
            
            visited[i] = false; // 백트래킹
        }
        
    }
    public boolean isPrime(int n){
        if(n==0||n==1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}