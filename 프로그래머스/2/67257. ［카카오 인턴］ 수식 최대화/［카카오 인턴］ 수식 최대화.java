import java.util.*;

class Solution {
    private static final String[][] precedences = {
        "+-*".split(""),
        "+*-".split(""),
        "*+-".split(""),
        "*-+".split(""),
        "-*+".split(""),
        "-+*".split("")
    };
    
    public long solution(String expression) {
        // 연산자까지 포함해서 분리해야하기 때문에 StringTokenizer 이용
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while(tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        long max = 0;
        for(String[] precedence : precedences) {
            // 절대값을 쳐준다.
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if(value > max) {
                max = value;
            }
        }
        
        return max;
    } 
    private long calculate(List<String> tokens, String[] precedence) {
        for(String op : precedence) {
            for(int i=0; i < tokens.size(); i++) {
                if(tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i-1));
                    long rhs = Long.parseLong(tokens.get(i+1));
                    long result = calculate(lhs, rhs, op);
                    // 하나씩 당겨준다.
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(result));
                    // 3개 제거하고 1개를 더했으니, 2만큼 인덱스를 앞으로 당겨준다.
                    i -= 2;
                }
            }
        }
        // 마지막엔 결과만 나옴.
        return Long.parseLong(tokens.get(0));
    }
    
    private long calculate(long lhs, long rhs, String operation) {
        return switch(operation) {
                case "+" -> lhs + rhs;
                case "-" -> lhs - rhs;
                case "*" -> lhs * rhs;
                default -> 0;
        };
    }
}