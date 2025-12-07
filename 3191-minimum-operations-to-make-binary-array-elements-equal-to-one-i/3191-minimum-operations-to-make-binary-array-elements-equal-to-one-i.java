class Solution {
    public int minOperations(int[] nums) {
        int flip=0;
        Boolean flips=false;
        if(nums[0]==0){

        for(int i=0;i<3;i++){
            if(nums[i]==0){
                nums[i]=1;
                flips=true;
                continue;
                
            }
            
            if(flips==true){
                if(nums[i]==0){
                    nums[i]=1;
                }
                else{
                    nums[i]=0;
                }
            }

        }}
        if(flips==true){
            flip++;
        }

     
       

        int l=0;
        int r=2;
        
        while(r<nums.length-1){
            l++;
            r++;
            if(nums[l]==0){
                nums[l]=1;
                flip++;
                if(nums[l+1]==0){
                    nums[l+1]=1;

                }
                else if(nums[l+1]==1){
                    nums[l+1]=0;
                }
                
               
                if(nums[r]==0){
                    nums[r]=1;
                }
                else if(nums[r]==1){
                    nums[r]=0;
                }
                
            
            }
           

        }

        

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                return -1;
            }
        }
        
        return flip;
    }
}