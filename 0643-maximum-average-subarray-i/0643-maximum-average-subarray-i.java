class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
        }
        int max=sum;
        int start=0;
        int end=k;
        while(end<nums.length){
            sum=sum-nums[start]+nums[end];
            max=Math.max(max,sum);
            end++;
            start++;
        }
        return (double)max/k;
        
    }
}