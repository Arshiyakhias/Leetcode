class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int left=0;
        int right=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[right]==0){
                count++;
            }
            while(count>1){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            if(count<=1){
                max=Math.max(max,(right-left+1));
                //System.out.println(right+" "+left);

            }
            right++;
        }
        return max;
    }
}