import java.util.ArrayList;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> value = new ArrayList<>();
        int valueI = 0;
        for(int i=0; i<dartResult.length(); i++){
            if(Character.isDigit(dartResult.charAt(i))){
                    if(Integer.parseInt(String.valueOf(dartResult.charAt(i))) == 0){ // 값으로 0이 나온경우
                        if(valueI == 0){ // 첫번째에 0이옴, 그냥 0인경우
                            value.add(Integer.parseInt(String.valueOf(dartResult.charAt(i))));
                            valueI++;
                        }
                        else{
                            if((Character.isDigit(dartResult.charAt(i-1)))){ // 0앞에 숫자가 있경우,, 10인경우
                                value.set(valueI-1,10);
                            }
                            else{ // 0앞에 숫자가 없는경우 그냥 0인경우
                            value.add(Integer.parseInt(String.valueOf(dartResult.charAt(i))));
                            valueI++;
                            }
                        }
                    }
                    else{ // 0이아닌경우
                        value.add(Integer.parseInt(String.valueOf(dartResult.charAt(i))));
                        valueI++;
                        
                    }
                }
            else{
                if("S".equals(String.valueOf(dartResult.charAt(i)))){
                    value.set(valueI-1,value.get(valueI-1));
                }
                else if("D".equals(String.valueOf(dartResult.charAt(i)))){
                    value.set(valueI-1,(int) Math.pow(value.get(valueI-1),2));
                }
                else if("T".equals(String.valueOf(dartResult.charAt(i)))){
                    value.set(valueI-1,(int) Math.pow(value.get(valueI-1),3));
                }
                else if("#".equals(String.valueOf(dartResult.charAt(i)))){
                    value.set(valueI-1,value.get(valueI-1)*-1);
                }
                else if("*".equals(String.valueOf(dartResult.charAt(i)))){
                    if(valueI == 1){
                        value.set(valueI-1,value.get(valueI-1)*2);
                    }
                    else{
                        value.set(valueI-1,value.get(valueI-1)*2);
                        value.set(valueI-2,value.get(valueI-2)*2);
                    }
                    
                }
            }
        }
        for(int i=0; i<value.size(); i++){
            answer += value.get(i);
        }
        return answer;
    }
}