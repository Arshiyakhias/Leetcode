class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int l=0;
        int r=0;
        int count=0;
        int ans1=0;
        while(r<nums.length){
            if(nums[r]%2!=0){
                count++;
            }
            while(count>k){
                if(nums[l]%2!=0){
                    count--;
                }
                l++;
            }
            if(count<=k){
                ans1=ans1+(r+l-1);

            }
            r++;
        }




        int l1=0;
        int r1=0;
        int count1=0;
        int ans2=0;
        k=k-1;
        while(r1<nums.length){
            if(nums[r1]%2!=0){
                count1++;
            }
            while(count1>k){
                if(nums[l1]%2!=0){
                    count1--;
                }
                l1++;
            }
            if(count1<=k){
                ans2=ans2+(r1+l1-1);

            }
            r1++;
        }
        if(ans1>ans2){
            return ans1-ans2;
        }
        return ans2-ans1;
        
    }
}