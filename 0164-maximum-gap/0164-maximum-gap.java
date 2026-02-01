class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            int val=Math.abs(nums[i]-nums[i+1]);
            max=Math.max(max,val);
        }
        return max;
    }
}