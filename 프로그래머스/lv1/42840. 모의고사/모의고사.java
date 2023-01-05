import java.util.ArrayList;
import java.util.Iterator;
class Solution {
    public int[] solution(int[] answers) {
        int one = 0;
        int two = 0;
        int three = 0;
        
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0;i<answers.length; i++){
            if(first[i%5] == answers[i]){
                one ++;
            }
            if(second[i%8] == answers[i]){
                two ++;
            }
            if(third[i%10] == answers[i]){
                three ++;
            }
        }
        System.out.println("one : "+one);
        System.out.println("two : "+two);
        System.out.println("three : "+three);
        ArrayList<Integer> aList = new ArrayList<>();
        if(one > two && one > three){
            aList.add(1);
        }
        else if(two > one  && two > three){
            aList.add(2);
        }
        else if(three > one  && three > two){
            aList.add(3);
        }
        
        else if(one == two && one > three){
            aList.add(1);
            aList.add(2);
        }
        else if(one == three && one > two){
            aList.add(1);
            aList.add(3);
        }
        else if(two == three && two > one){
            aList.add(2);
            aList.add(3);
        }
        else if(one == three && one == two){
            aList.add(1);
            aList.add(2);
            aList.add(3);
        }
        int[] answer = new int[aList.size()];
        Iterator iter = aList.iterator();
        int i = 0;
        while(iter.hasNext()){
            answer[i] = (int) iter.next();
            i++;
        }
        return answer;
    }
}