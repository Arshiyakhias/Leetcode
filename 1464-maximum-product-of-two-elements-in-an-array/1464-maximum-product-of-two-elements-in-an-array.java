class Solution {
    public int maxProduct(int[] nums) {
       Arrays.sort(nums);
       int first=nums[nums.length-1];
       int second=nums[nums.length-2];
       first=first-1;
       second=second-1;
       return first*second; 
    }
}