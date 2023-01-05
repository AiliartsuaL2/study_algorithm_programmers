import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        // 좌표값 맵 만들어서 걸어본곳 boolean 써서 
        // 안걸어본 곳은 answer++
        HashMap<ArrayList,Boolean> dirsMap = new HashMap<>();
        
        String[] dirsStr = dirs.split("");
        int x = 0;
        int y = 0;
        for(String dir : dirsStr){
            ArrayList<Integer>curCdn = new ArrayList<>();
            ArrayList<Integer>reverseCdn = new ArrayList<>();
            reverseCdn.add(0);
            reverseCdn.add(0);
            reverseCdn.add(0);
            reverseCdn.add(0);
            boolean yesPut = false;
            if(dir.equals("U")){
                if(y < 5){
                    curCdn.add(0,x); // 이전 좌표
                    curCdn.add(1,y); // 이전 좌표
                    reverseCdn.set(2,x);
                    reverseCdn.set(3,y);
                    y++;
                    curCdn.add(2,x); // 신규 좌표
                    curCdn.add(3,y); // 신규 좌표
                    reverseCdn.set(0,x);
                    reverseCdn.set(1,y);
                    yesPut = true;
                }  
            }
            else if(dir.equals("D")){
                if(y > -5){
                    curCdn.add(0,x); // 이전 좌표
                    curCdn.add(1,y); // 이전 좌표
                    reverseCdn.set(2,x);
                    reverseCdn.set(3,y);
                    y--;
                    curCdn.add(2,x); // 신규 좌표
                    curCdn.add(3,y); // 신규 좌표
                    reverseCdn.set(0,x);
                    reverseCdn.set(1,y);
                    yesPut = true;
                }  
            }
            else if(dir.equals("R")){
                if(x < 5){
                    curCdn.add(0,x); // 이전 좌표
                    curCdn.add(1,y); // 이전 좌표
                    reverseCdn.set(2,x);
                    reverseCdn.set(3,y);
                    x++;
                    curCdn.add(2,x); // 신규 좌표
                    curCdn.add(3,y); // 신규 좌표
                    reverseCdn.set(0,x);
                    reverseCdn.set(1,y);
                    yesPut = true;
                }  
            }
            else if(dir.equals("L")){
                if(x > -5){
                    curCdn.add(0,x); // 이전 좌표
                    curCdn.add(1,y); // 이전 좌표
                    reverseCdn.set(2,x);
                    reverseCdn.set(3,y);
                    x--;
                    curCdn.add(2,x); // 신규 좌표
                    curCdn.add(3,y); // 신규 좌표
                    reverseCdn.set(0,x);
                    reverseCdn.set(1,y);
                    yesPut = true;
                }
            }
            if(yesPut == true && dirsMap.getOrDefault(curCdn,false) == false){
                if(dirsMap.getOrDefault(reverseCdn,false) == false){
                    dirsMap.put(reverseCdn,true);
                    dirsMap.put(curCdn,true);
                    answer++;
                }
            }
        }
        return answer;
    }
}