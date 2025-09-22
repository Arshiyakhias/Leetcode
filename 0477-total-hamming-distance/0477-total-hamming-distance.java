class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int val=nums[i]^nums[j];
                int num=Integer.bitCount(val);
       
                sum=sum+num;
            }
            
        }
        

        
       
        
        

        return sum;
    }
}