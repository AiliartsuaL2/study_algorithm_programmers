import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        int[] numberArr = numbers.chars()
            .map(n -> n - '0')
            .toArray();
        
        recursion(0, numberArr, primes, new boolean[numberArr.length]);
        
        return primes.size();
    }
    
    private void recursion(int now, int[] numbers, Set<Integer> primes, boolean[] isUsed) {
        // 소수면 현재 값 추가
        if(isPrime(now)) {
            primes.add(now);
        }
        // 종료조건이 없어도, 리스트가 비어있으면 아래 반복문이 실행되지 않음.
        
        for(int i = 0; i < numbers.length; i++) {
            if(isUsed[i]) {
                continue;
            }
            // 백트래킹
            isUsed[i] = true;
            int next = (now * 10) + numbers[i];
            recursion(next, numbers, primes, isUsed);
            // 다음 반복문에서는 영향 없도록 false 처리
            isUsed[i] = false;
        }
    }
    
    private boolean isPrime(int number) {
        if(number <= 1) { 
            return false;
        }
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}