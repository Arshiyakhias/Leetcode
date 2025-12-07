class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0;
        int r=0;
        int prod=1;
        int count=0;
        while(r<nums.length){
            prod=prod*nums[r];
            System.out.println(nums[l]);
            while(prod>=k && l<=r){
              
                prod=prod/nums[l];
                l++;
            }
            if(prod<k){
               
                count=count+(r-l+1);

            }
            r++;

        }
        return count;
    }
}