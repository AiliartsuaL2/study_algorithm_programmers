class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftThumb = -1;
        int rightThumb = -1;
        int leftDistance = 0;
        int rightDistance = 0;
        
        for(int i=0; i<numbers.length; i++){
            switch(numbers[i]){
                case 1,4,7 : leftThumb = numbers[i];
                    answer+="L"; 
                    break;
                case 3,6,9 : rightThumb = numbers[i];
                    answer+="R";
                    break;
                case 2 :
                    leftDistance = 0;
                    rightDistance = 0;
                    switch(leftThumb){
                        case 2 :
                            leftDistance = 0;
                            break;
                        case 1 , 5 :
                            leftDistance = 1;
                            break;
                        case 4 , 8  :
                            leftDistance = 2;
                            break;
                        case 7 , 0 :
                            leftDistance = 3;
                            break;
                        case -1 :
                            leftDistance = 4;
                            break;
                        }
                    switch(rightThumb){
                        case 2 :
                            rightDistance = 0;
                            break;
                        case 3 , 5 :
                            rightDistance = 1;
                            break;
                        case 6 , 8  :
                            rightDistance = 2;
                            break;
                        case 0,9 :
                            rightDistance = 3;
                            break;
                        case -1  :
                            rightDistance = 4;
                            break;
                        }
                    if(leftDistance > rightDistance){
                        rightThumb = numbers[i];
                        answer+="R";
                        break;
                    }
                    else if(leftDistance < rightDistance){
                        leftThumb = numbers[i];
                        answer+="L"; 
                        break;
                    }
                    else{ 
                        if(hand.equals("left")){
                            leftThumb = numbers[i];
                            answer+="L"; 
                            break;
                        }
                        else{
                            rightThumb = numbers[i];
                            answer+="R";
                            break;
                        }
                    }
                case 5 :
                    leftDistance = 0;
                    rightDistance = 0;
                    switch(leftThumb){
                        case 5 : 
                            leftDistance = 0;
                            break;
                        case 2,4,8 : 
                            leftDistance = 1;
                            break;
                        case 1,7,0  :
                            leftDistance = 2;
                            break;
                        case -1 :
                            leftDistance = 3;
                            break;
                        }
                    switch(rightThumb){
                        case 5 :
                            rightDistance = 0;
                            break;
                        case 2,6,8 :
                            rightDistance = 1;
                            break;
                        case 3,9,0  :
                            rightDistance = 2;
                            break;
                        case -1  :
                            rightDistance = 3;
                            break;
                        }
                    if(leftDistance > rightDistance){
                        rightThumb = numbers[i];
                        answer+="R";
                        break;
                    }
                    else if(leftDistance < rightDistance){
                        leftThumb = numbers[i];
                        answer+="L"; 
                        break;
                    }
                    else{ 
                        if(hand.equals("left")){
                            leftThumb = numbers[i];
                            answer+="L"; 
                            break;
                        }
                        else{
                            rightThumb = numbers[i];
                            answer+="R";
                            break;
                        }
                    }
                case 8 :
                    leftDistance = 0;
                    rightDistance = 0;
                    switch(leftThumb){
                        case 8 : 
                            leftDistance = 0;
                            break;
                        case 0,5,7 : 
                            leftDistance = 1;
                            break;
                        case -1,2,4  :
                            leftDistance = 2;
                            break;
                        case 1 :
                            leftDistance = 3;
                            break;
                        }
                    switch(rightThumb){
                        case 8 :
                            rightDistance = 0;
                            break;
                        case 0,5,9 :
                            rightDistance = 1;
                            break;
                        case -1,2,6  :
                            rightDistance = 2;
                            break;
                        case 3 :
                            rightDistance = 3;
                            break;
                        }
                    if(leftDistance > rightDistance){
                        rightThumb = numbers[i];
                        answer+="R";
                        break;
                    }
                    else if(leftDistance < rightDistance){
                        leftThumb = numbers[i];
                        answer+="L"; 
                        break;
                    }
                    else{ 
                        if(hand.equals("left")){
                            leftThumb = numbers[i];
                            answer+="L"; 
                            break;
                        }
                        else{
                            rightThumb = numbers[i];
                            answer+="R";
                            break;
                        }
                    }
                case 0 :
                    leftDistance = 0;
                    rightDistance = 0;
                    switch(leftThumb){
                        case 0 : 
                            leftDistance = 0;
                            break;
                        case -1,8 : 
                            leftDistance = 1;
                            break;
                        case 5,7  :
                            leftDistance = 2;
                            break;
                        case 2,4 :
                            leftDistance = 3;
                            break;
                        case 1 :
                            leftDistance = 4;
                            break;
                        }
                    switch(rightThumb){
                        case 0 :
                            rightDistance = 0;
                            break;
                        case -1,8 :
                            rightDistance = 1;
                            break;
                        case 5,9  :
                            rightDistance = 2;
                            break;
                        case 2,6 :
                            rightDistance = 3;
                            break;
                        case 3 :
                            rightDistance = 4;
                            break;
                        }
                    if(leftDistance > rightDistance){
                        rightThumb = numbers[i];
                        answer+="R";
                        break;
                    }
                    else if(leftDistance < rightDistance){
                        leftThumb = numbers[i];
                        answer+="L"; 
                        break;
                    }
                    else{ 
                        if(hand.equals("left")){
                            leftThumb = numbers[i];
                            answer+="L"; 
                            break;
                        }
                        else{
                            rightThumb = numbers[i];
                            answer+="R";
                            break;
                        }
                    }
            }
                
        }
            
        return answer;
    }
}