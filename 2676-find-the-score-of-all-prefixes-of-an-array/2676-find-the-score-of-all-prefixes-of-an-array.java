class Solution {
    public long[] findPrefixScore(int[] nums) {
        int[]max=new int[nums.length];
        max[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            max[i]=Math.max(nums[i],max[i-1]);
        }
        
        long[]ans=new long[nums.length];
        ans[0]=nums[0]+max[0];
        for(int i=1;i<ans.length;i++){
            ans[i]=ans[i-1]+nums[i]+max[i];
        }
        return ans;
        
    }
}