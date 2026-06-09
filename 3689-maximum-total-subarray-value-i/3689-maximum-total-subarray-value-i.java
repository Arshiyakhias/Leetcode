class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max=Integer.MIN_VALUE;
        long min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        System.out.println(max);
        max=max-min;
        System.out.println(max);
        max=max*k;
        System.out.println(max);
        return max;
    }
}