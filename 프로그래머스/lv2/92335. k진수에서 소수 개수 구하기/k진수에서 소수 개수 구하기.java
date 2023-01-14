class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kJinsu = Integer.toString(n,k);
        String kJinsuSpl[] = kJinsu.split("0");

        for(int i=0; i<kJinsuSpl.length;i++){
            if(kJinsuSpl[i].length()>0){
                if(!kJinsuSpl[i].contains("0")){
                    long tmp = Long.parseLong(kJinsuSpl[i],10);
                    if(tmp != 1){
                        if(isPrime(tmp)){
                            answer ++;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public boolean isPrime(long a){
        boolean ip = true;
            for(long i=2; i<=Math.sqrt(a); i++){
                if(a%i == 0){
                    ip = false;
                    break;
                }
            }
        return ip;
    }
}
