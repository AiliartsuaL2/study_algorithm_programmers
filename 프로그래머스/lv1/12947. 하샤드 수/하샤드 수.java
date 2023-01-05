class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num = 0;
        num = (int) Math.log10(x)+1; // 자릿수
        int sa = 0 ; // 10의 자리수값 제곱
        int sb = 0;
        int arr[] = new int[(num)];
        int sum = 0;
        
        for(int i=1; i<=num; i++){
            sa = (int) Math.pow(10,i) ; // 10의 자리수값 제곱
            sb = (int) Math.pow(10,i-1);
            arr[i-1] = ((x%sa - x%sb) / sb);
        }
        for(int i=0; i<num; i++){
            sum += arr[i];
        }
        if(x % sum == 0){
            answer = true;
        }
        else{
            answer = false;
        }
        return answer;
    }
}