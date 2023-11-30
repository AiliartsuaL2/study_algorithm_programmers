import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        List<Integer> numberList = Arrays.asList(numbers.split("")).stream()
            .map(n -> Integer.parseInt(n))
            .collect(Collectors.toList());
        recursion(0, numberList, primes);
        return primes.size();
    }
    
    private void recursion(int now, List<Integer> numbers, Set<Integer> primes) {
        // 소수면 현재 값 추가
        if(isPrime(now)) {
            primes.add(now);
        }
        // 종료조건이 없어도, 리스트가 비어있으면 아래 반복문이 실행되지 않음.
        
        for(int i = 0; i < numbers.size(); i++) {
            int next = (now * 10) + numbers.get(i);
            // 전이되는 상태의 숫자를 제거,,
            // 기존 리스트 복사 후 삭제
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            // 리턴된 값들을 결과 집합에 추가
            recursion(next, nextNumbers, primes);
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