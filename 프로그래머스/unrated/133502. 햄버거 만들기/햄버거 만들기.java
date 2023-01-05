import java.util.LinkedList;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        LinkedList<Integer> aList = new LinkedList<>();
        for(int i =0; i<ingredient.length; i++){
            aList.add(ingredient[i]);
            if(aList.size()>3){
                int a = aList.size()-1;
                if(aList.get(a) == 1 && aList.get(a-1) == 3 && aList.get(a-2) == 2 && aList.get(a-3) == 1){
                    aList.remove(a);
                    aList.remove(a-1);
                    aList.remove(a-2);
                    aList.remove(a-3);
                    answer ++;
                }
            }
        }
        
        return answer;
    }
}