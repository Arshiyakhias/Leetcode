class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum<0){
                
                max=Math.max(sum,max);
                sum=0;
            }
            else{
                max=Math.max(sum,max);
            }
        }
        return max;
        
    }
}