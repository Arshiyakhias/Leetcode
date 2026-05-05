class Solution {
    public int alternatingSum(int[] nums) {
        int val=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                val=val+nums[i];
            }
            else{
                val=val-nums[i];
            }
        }
        return val;
    }
}