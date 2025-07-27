class Solution {
    public int[] searchRange(int[] nums, int target) {
        int min=Integer.MAX_VALUE;
        int[]ans;
        ans=new int[2];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                min=Math.min(min,i);
                max=Math.max(max,i);
            }
        }
        ans[0]=min;
        ans[1]=max;
        if(min>max){
            ans[0]=-1;
            ans[1]=-1;
        }
        return ans;
    }
}