class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        
        for(int i=0;i<nums.length;i++){
            int count=0;
            int sums=0;
            for(int j=1;j<=nums[i];j++){
                if(nums[i]%j==0){
                    
                   
                    sums=sums+j;
                    count++;
                }
                if(count>4){
                    break;
                    
                }


            }
            if(count==4){
                sum=sum+sums;
            }
        }
        return sum;
        
    }
}