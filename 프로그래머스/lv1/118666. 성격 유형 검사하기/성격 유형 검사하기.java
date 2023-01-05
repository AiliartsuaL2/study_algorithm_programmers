import java.util.HashMap;

class Solution {
    HashMap<String,Integer> sMap = new HashMap<>();
    String[] survey;
    int[] choices;
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        sMap.put("R",0);
        sMap.put("T",0);
        sMap.put("C",0);
        sMap.put("F",0);
        sMap.put("J",0);
        sMap.put("M",0);
        sMap.put("A",0);
        sMap.put("N",0);
        for(int i=0; i<survey.length; i++){            
            if(survey[i].equals("RT")){
                sMapPutter("R","T",choices[i]);
            }
            else if(survey[i].equals("TR")){
                sMapPutter("T","R",choices[i]);
            }
            else if(survey[i].equals("CF")){
                sMapPutter("C","F",choices[i]);
                
            }
            else if(survey[i].equals("FC")){
                sMapPutter("F","C",choices[i]);
                
            }
            else if(survey[i].equals("JM")){
                sMapPutter("J","M",choices[i]);
                
            }
            else if(survey[i].equals("MJ")){
                sMapPutter("M","J",choices[i]);
                
            }
            else if(survey[i].equals("AN")){
                sMapPutter("A","N",choices[i]);
            }
            else if(survey[i].equals("NA")){
                sMapPutter("N","A",choices[i]);
            }
        }
        if(sMap.get("R") >= sMap.get("T")){
            answer += "R";
        }
        else{
            answer += "T";
        }
        if(sMap.get("C") >= sMap.get("F")){
            answer += "C";
        }
        else{
            answer += "F";
        }
        if(sMap.get("J") >= sMap.get("M")){
            answer += "J";
        }
        else{
            answer += "M";
        }
        if(sMap.get("A") >= sMap.get("N")){
            answer += "A";
        }
        else{
            answer += "N";
        }
        System.out.println(sMap);
        return answer;
    }
    void sMapPutter(String type1, String type2, int c){
        switch(c){
            case 1: 
                sMap.put(type1,sMap.get(type1)+3);
                break;
            case 2: 
                sMap.put(type1,sMap.get(type1)+2);
                break;
            case 3: 
                sMap.put(type1,sMap.get(type1)+1);
                break;
            case 4: 
                break;
            case 5: 
                sMap.put(type2,sMap.get(type2)+1);
                break;
            case 6: 
                sMap.put(type2,sMap.get(type2)+2);
                break;
            case 7: 
                sMap.put(type2,sMap.get(type2)+3);
                break;
            }    
        }
}