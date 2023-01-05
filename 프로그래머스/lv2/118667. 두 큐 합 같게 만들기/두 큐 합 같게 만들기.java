import java.util.LinkedList;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        long sum1 = 0;
        long sum2 = 0;
        LinkedList<Integer> queList1 = new LinkedList<>();
        LinkedList<Integer> queList2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            int a = queue1[i];
            queList1.add(a);
            sum1 += a;
        }
        for(int i=0; i<queue2.length; i++){
            int a = queue2[i];
            queList2.add(a);
            sum2 += a;
        }
        
        long avg = (sum1+sum2)/2;
        int cnt = 0;
        
        while(true){
            if(cnt > queue1.length+queue2.length+2){
                answer = -1;
                break;
            }
            if(sum1 == avg){
                answer = cnt;
                break;
            }
            if(sum1>avg){
                if(queList1.isEmpty()){
                    answer = -1;
                    break;
                }
                int tmp = queList1.removeFirst();
                sum1-=tmp;
                queList2.add(tmp);
            }
            else{
                if(queList2.isEmpty()){
                    answer = -1;
                    break;
                }
                int tmp = queList2.removeFirst();
                sum1+=tmp;
                queList1.add(tmp);
            }
            cnt++;
        }
        
        
        return answer;
    }
}