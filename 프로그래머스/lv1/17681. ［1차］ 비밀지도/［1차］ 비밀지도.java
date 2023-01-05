class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String [n];
        String[] Sarr1 = new String[n];
        String[] Sarr2 = new String[n];
        for(int i = 0; i<n; i++){
            Sarr1[i] = "0".repeat(n-Integer.toString(arr1[i],2).length());
            Sarr2[i] = "0".repeat(n-Integer.toString(arr2[i],2).length());
            Sarr1[i] += Integer.toString(arr1[i],2);
            Sarr2[i] += Integer.toString(arr2[i],2);
            
            String tmp = "";
            for(int j = 0; j<Sarr1[i].length(); j++){
                    if((int)(Sarr1[i].charAt(j)) == 48 && (int)(Sarr2[i].charAt(j)) == 48){
                        tmp += " ";
                    } 
                    else{
                        tmp += "#";
                    }
                }
            answer[i] = tmp;
            }
        System.out.println(Sarr1[1]);
        System.out.println(Sarr2[2]);
        return answer;
    }
}
