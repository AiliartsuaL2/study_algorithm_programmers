import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        LinkedList<String> numList = new LinkedList<>();
        for(int i=0; i<numbers.length; i++){
            String num = Integer.toString(numbers[i]);
            numList.add(num);
        } 
       Collections.sort(numList, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
                //오름차순 정렬 (o1+o2).compareTo(o1+o2);
            }
        });
        
        if (numList.get(0).equals("0")) return "0"; // 내림차순 했을때니까, 첫값이 0이면 그 뒤는 다 0,,
        for(String num : numList){
            answer += num;
        }
        
        return answer;
    }
}