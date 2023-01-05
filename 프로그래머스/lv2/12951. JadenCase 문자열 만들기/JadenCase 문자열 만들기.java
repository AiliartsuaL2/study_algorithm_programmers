import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s," ",true);
        LinkedList<String> sList = new LinkedList<>();
        	while(st.hasMoreTokens()){
                sList.add(st.nextToken());
	        }
        System.out.println(sList);
        for(int i=0; i<sList.size(); i++){
            String str = sList.get(i);
            String tmp = "";
            if(Character.isAlphabetic(str.charAt(0))){
                tmp = String.valueOf(str.charAt(0)).toUpperCase();
                tmp += str.substring(1,str.length()).toLowerCase();
            }
            else{
                tmp = str.toLowerCase();
            }
            sList.set(i,tmp);
            answer += sList.get(i);
        }
        return answer;
    }
}