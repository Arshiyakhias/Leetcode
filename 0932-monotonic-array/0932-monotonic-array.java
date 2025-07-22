class Solution {
    public boolean isMonotonic(int[] nums) {
        int asc=0;
        int desc=0;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1] ){
                asc++;

            }
            else if(nums[i]==nums[i+1]){
                count++;

            }
            else if(nums[i]>nums[i+1]){
                desc++;
            }
        }
        if(asc+count==nums.length-1 || desc+count==nums.length-1){
            return true;
        }
        return false;
        
    }
}