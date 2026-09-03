class Solution {
    public int minSwaps(int[] data) {
        int k=0;
        for(int i=0;i<data.length;i++){
            if(data[i]==1){
                k++;
            }
        }

        //min swaps is max ones in that window with least 0s in that window

        int count=0;
        

        for(int i=0;i<k;i++){
            if(data[i]==1){
                count++;
            }
        }
        int max=count;
        for(int i=1;i<(data.length-k+1);i++){
            if(data[i-1]==1){
                count--;
            }
            if(data[i+k-1]==1){
                count++;
            }
            max=Math.max(max,count);
        }
        return k-max;
    }
}