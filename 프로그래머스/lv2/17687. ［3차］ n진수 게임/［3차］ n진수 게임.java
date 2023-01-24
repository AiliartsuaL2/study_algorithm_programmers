class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int order = 1;
        int index = 0;
        int ansLen = 0;
        int pOrder = p;
        if(p==m){
            pOrder = 0;
        }
        while(ansLen < t){
            String num = Integer.toString(index,n); // 값을 진법 변환시킴
            for(int i=0; i<num.length(); i++){ // 진법변환시킨값을 돌면서
                if(order % m == pOrder && ansLen < t){ // 순서가 p차례 이면서 길이가 t보다 작으면
                    String tmp = String.valueOf(num.charAt(i)); //값 추출
                    tmp = tmp.toUpperCase();
                    answer += tmp; // 길이 더함
                    ansLen++; // 길이증가
                    order ++; // 순서증가
                }
                else if(order % m == p && ansLen>=t){
                    break;
                }
                else{
                    order++;
                }
            }
            index ++; // 값증가
        }    

        return answer;
    }
}