import java.util.HashMap;
import java.util.ArrayList;

class Solution {    
    HashMap<String,Integer> dictMap = new HashMap<>();
    ArrayList<Integer> answerList = new ArrayList<>();
    int mapIndex = 0;

    public int[] solution(String msg) {
        for(int i=1; i<27; i++){
            dictMap.put(String.valueOf((char)(i+64)),i);
        }
        mapIndex = 26;
        def(msg,0,"");
        int[] answer = new int[answerList.size()];
        for(int i =0;i<answer.length;i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    public void def(String str,int index, String lastStr){
        if(index == str.length()){
            String paramStr = lastStr;
            String tmp = String.valueOf(str.charAt(index-1));
            lastStr += tmp;
            answerList.add(dictMap.get(paramStr));

            return;
        }
        String paramStr = lastStr;
        String tmp = String.valueOf(str.charAt(index));
        lastStr += tmp;
        //받았을때 다음값 더한걸 확인하고 있으면 def 없으면 map에저장하고 출력(list추가) 진행..

        if(dictMap.containsKey(lastStr)){
            index++;
            def(str,index,lastStr);
        }
        else{
            dictMap.put(lastStr,++mapIndex);
            answerList.add(dictMap.get(paramStr));
            def(str,index,"");
        }
    }
}
