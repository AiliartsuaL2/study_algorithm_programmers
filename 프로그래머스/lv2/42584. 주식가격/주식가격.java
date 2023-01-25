import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};

            Queue<Integer> pricesQue = new LinkedList<>();
            ArrayList<Integer> answerArrayList = new ArrayList<>();

            for(int price : prices)
            {
                pricesQue.offer(price);
            }

            int price = 0;
            int time = 0;
            while(!pricesQue.isEmpty())
            {
                time=0;
                price = pricesQue.peek();
                pricesQue.poll();


                //마지막 가격이면 바로 종료
                if(pricesQue.isEmpty())
                {
                    answerArrayList.add(0);
                    break;
                }


                Iterator<Integer> iterator = pricesQue.iterator();
                int camparePrices=0;
                while(iterator.hasNext())
                {
                    time++;
                    camparePrices = iterator.next();
                    if(price > camparePrices)
                    {
                        break;
                    }
                }
                answerArrayList.add(time);
            }
            answer = new int[answerArrayList.size()];
            for ( int i=0; i<answerArrayList.size(); i++)
            {
                answer[i] = answerArrayList.get(i);
            }


            return answer;
    }
}