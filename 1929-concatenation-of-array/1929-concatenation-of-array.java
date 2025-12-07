class Solution {
    public int[] getConcatenation(int[] nums) {
        int[]ans;
        ans=new int[nums.length+nums.length];
        int index=0;
        for(int i=0;i<nums.length;i++){
            ans[index]=nums[i];
            index++;
        }
        for(int i=0;i<nums.length;i++){
            ans[index]=nums[i];
            index++;
        }
        return ans;
    }
}