import java.util.*;
class Solution {    
    boolean[] visited;
    int len;
    int cnt;
    Set<String> list = new HashSet<>();
    List<String> list2 = new ArrayList<>();
    public int solution(String[][] relation) {
        int answer = 0;
        
        len = relation[0].length;
        cnt = relation.length;
        visited = new boolean[len];
        
        for(int i=1; i<=len; i++){
            comb(0,i,relation);
            unique(relation);
            list.clear();
        }
        
        return list2.size();
    }
    public void comb(int start, int r, String[][] relation){
        if(r==0){
            String temp="";
            for(int i=0;i<len;i++){
                if(visited[i]){
                    temp+=i; // 컬럼들의 조합(String으로 123 이런식으로 조합이 들어감)
                }
            }
            list.add(temp); // Set에다가 넣음
        }
        for(int i=start; i<len; i++){
            if(!visited[i]){
                visited[i] = true; // 방문처리
                comb(start+1,r-1,relation);
                visited[i] = false; // 백트래킹
            }
        }
    }
    public void unique(String[][] relation){
        for(String data : list){
            String[] temp = data.split(""); // Set 데이터 꺼내서 temp 배열에 넣음
            int[] arr = new int[temp.length];
            for(int i=0; i<temp.length;i++){
                int c = Integer.parseInt(temp[i]);
                arr[i] = c;
            }
            
            Set<String> unqSet = new HashSet<>();
            for(int i=0; i<cnt; i++){
                String cdd = "";
                for(String data2 : temp){
                    int c = Integer.parseInt(data2);
                    cdd+=relation[i][c];// 모든 컬럼의 조합에 해당하는 값
                }
                unqSet.add(cdd);
            }
            if(unqSet.size()==cnt){ // 유일성을 만족한다면 최소성 검사 진행
                boolean flag = false;
                for(String data3 : list2){
                    int cnt = 0;
                    String[] temp3 = data3.split("");
                    for(String data4 : temp3){
                        if(data.contains(data4)){
                            cnt++;
                        }
                    }
                    if(cnt == data3.length()){
                        flag = true;
                    }
                }
                if(!flag){
                    list2.add(data);
                }
            }
            
        }
    }
    
}