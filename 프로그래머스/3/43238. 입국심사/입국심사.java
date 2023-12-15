class Solution {
    public long solution(int n, int[] times) {
        // 특정 시간동안 x명을 처리하는 각 심사대의 총 합이 n인 최소 시간을 구한다. 
        // 특정 시간의 최댓값 = 10억 * 10억
        long start = 0;
        long end = 1000000000000000000L;
        while(end > start) {
            long t = (start + end) / 2;
            
            // 정답을 검사하고 범위를 좁힌다.
            if(isValid(t, n, times)) {
                end = t;
                continue;
            }
            // 2진 탐색
            start = t + 1;
        }
        return start;
    }
    
    // 검사 시간동안 심사 위원들이 처리할 수 있는 인원들의 총 합이 대기 인원보다 큰지 검증
    private boolean isValid(long t, long n, int[] times) {
        long c = 0;
        for (int time : times) {
            c += t / time;
        }
        return c >= n;
    }
}