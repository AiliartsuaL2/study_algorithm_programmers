import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>() {
			    @Override
				public int compare(int[] o1, int[] o2) {
			    	 if(o1[col-1] == o2[col-1]) {
		                	 return o2[0] - o1[0];
			    	 }else {
			    		 return o1[col-1] - o2[col-1]; 
			    	 }
		           }
		    });
        
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=row_begin-1; i<=row_end-1; i++){
            int sum = 0;
            for(int j=0; j<data[0].length; j++){
                sum += (data[i][j] % (i+1));
            }
            aList.add(sum);
        }
        int xor = 0;
        for(int a=0; a<aList.size(); a++){
            xor ^= aList.get(a);
        }
        
        return xor;
    }
}