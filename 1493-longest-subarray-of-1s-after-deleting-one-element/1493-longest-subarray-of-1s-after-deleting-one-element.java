class Solution {
    public int longestSubarray(int[] nums) {
        
        int count_zero=0;
        int max=0;
        int r=0;
        int l=0;
        int k=1;
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
                int len=r-l;
                max=Math.max(max,len);
            }
            r++;
        }
        return max;
    }
}