class Solution {
    public long dividePlayers(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        long sum=nums[left]+nums[right];
        long pro=0;
        while(left<right){
            long sums=nums[left]+nums[right];
            if(sums!=sum){
                return -1;
            }
            long val=nums[left]*nums[right];
            pro=pro+val;
            left++;
            right--;

        }
        return pro;
    }
}