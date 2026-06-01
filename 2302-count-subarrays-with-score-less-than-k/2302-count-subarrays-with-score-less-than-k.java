class Solution {
    public long countSubarrays(int[] nums, long k) {
        int right=0;
        int left=0;
        long count=0;
        long sums=0;
        long vals=0;
        while(left<=right && right<nums.length){
            sums=sums+nums[right];

            vals=sums*(right-left+1);
           
            while(vals>=k){
                sums=sums-nums[left];
                left++;
                
                vals=sums*(right-left+1);
                
            }
            if(vals<k){
                
                count=count+(right-left+1);
               

            }
            right++;
        }
        return count;
    }
}