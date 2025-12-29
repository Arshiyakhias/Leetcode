class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        if(k==0){
            
            int len=0;
            int count=0;
            int ans=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    count++;
                    len++;
                }
                if(nums[i]!=0){
                    ans=ans+(len*(len+1)/2);
                    len=0;

                }
            }
          
            ans=ans+len*(len+1)/2;
            if(count==nums.length){
                return nums.length*(nums.length+1)/2;
            }
            return ans;
            
        }
        if(nums.length==1 && nums[0]!=k){
            return 0;
        }
        int l=0;
        int r=0;
        int sum=0;
        int count=0;

        while(r<nums.length){
            sum=sum+nums[r];

            while(sum>k){
                sum=sum-nums[l];
                l++;

            }
            if(sum<=k){
                count=count+(r-l+1);


            }
            r++;

        }
        int l1=0;
        int r1=0;
        int sum1=0;
        k=k-1;
        int count1=0;

        while(r1<nums.length){
            sum1=sum1+nums[r1];

            while(sum1>k){
                sum1=sum1-nums[l1];
                l1++;

            }
            if(sum1<=k){
                count1=count1+(r1-l1+1);


            }
            r1++;

        }
        return count-count1;

    }
}