class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int candidate=0;
        for(int num:nums){
            if(candidate==num){
                count++;
            }
            else if(count==0){
                count++;
                candidate=num;
            }
            else{
                count--;
            }
        }
        
        return candidate;
    }
}