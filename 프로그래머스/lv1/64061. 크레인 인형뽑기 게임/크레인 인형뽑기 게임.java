import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> aStack = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][moves[i]-1] == 0){ // 해당칸에 인형이 없을경우 
                    continue; // 아무것도 안함
                }
                else{ // 인형이 있으면
                    if(aStack.size()>0){// 사이즈가 0보다 크면
                        if(aStack.peek() == board[j][moves[i]-1]){ // 똑같은 인형이면
                            board[j][moves[i]-1] = 0; // 데이터를 0으로 바꿈(뽑았다고 침)
                            aStack.pop(); // 터졌으니까 기존꺼 뽑고
                            answer+=2;  // 인형은 2개 터지니까 +2
                            break;
                        }
                        else{ // 다른 인형이면
                            aStack.push(board[j][moves[i]-1]); // 뽑아서 스택에 넣고
                            board[j][moves[i]-1] = 0; // 데이터를 0으로 바꿈
                            break;
                        }
                    }
                    else{ // 스택이 비어있으면
                            aStack.push(board[j][moves[i]-1]); // 뽑아서 스택에 넣고
                            board[j][moves[i]-1] = 0; // 데이터를 0으로 바꿈
                            break;
                    }
                }
            }
        }
        return answer;
    }
}