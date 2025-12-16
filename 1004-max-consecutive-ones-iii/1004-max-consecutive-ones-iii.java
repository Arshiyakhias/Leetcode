class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int count_zero=0;
        int len=0;

        while(r<nums.length){

            if(nums[r]==0){
                count_zero++;
            }
            while(count_zero>k){
                if(nums[l]==0){
                    count_zero--;

                }
                l++;

            }
            if(count_zero<=k){
                int val=r-l+1;
                len=Math.max(len,val);            
            }
            r++;
            
        }
        return len;
    }
}