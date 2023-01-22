import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> userMap = new HashMap<>(); 
        ArrayList<String> recordList = new ArrayList<>();        
         for(int i=0; i<record.length; i++){ // 이름부터받고 change
            String recordStr = record[i];
            String[] recordSet = recordStr.split(" ");
            String status = recordSet[0];
            String uid = recordSet[1];
            if(status.equals("Enter")){
                String name = recordSet[2];
                userMap.put(uid,name);   
                recordList.add(uid+"님이 들어왔습니다.");         
            } 
            else if(status.equals("Leave")){
                recordList.add(uid+"님이 나갔습니다."); 
            }
            else if(status.equals("Change")){
                String name = recordSet[2];
                userMap.put(uid,name);              
            }
         }

        String[] answer = new String[recordList.size()];
        int logIdx = 0;
        for(String str : recordList){
            int endOfId = str.indexOf("님");
            String userId = str.substring(0, endOfId);
            answer[logIdx++] = str.replace(userId, userMap.get(userId));
        }


        return answer;
    }
}
