import java.util.LinkedList;
class Solution {
    public LinkedList<Long> solution(int n, long left, long right) {
        LinkedList<Long> aList = new LinkedList<>();

        int[] answer = new int[(int)right-(int)left+1];
        for(long i=left; i<=right; i++){
            aList.add(Math.max(i/n,i%n)+1);
        }


        return aList;
    }
}
