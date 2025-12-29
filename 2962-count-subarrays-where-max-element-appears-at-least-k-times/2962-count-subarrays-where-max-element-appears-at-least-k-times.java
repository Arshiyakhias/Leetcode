class Solution {
    public long countSubarrays(int[] nums, int k) {



        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);

        }
        


        k=k-1;



        int r2=0;
        int l2=0;
        long count2=0;
        long ans2=0;
        while(r2<nums.length){
            if(nums[r2]==max){
                count2++;
            }
            while(count2>k){
                if(nums[l2]==max){
                    count2--;
                }
                l2++;

            }
            if(count2<=k){
                ans2=ans2+(r2-l2+1);

            }
            r2++;
        }
  

        System.out.println(ans2);
    
     
        int start=0;
        int end=nums.length-1;
        long fin=(long)nums.length*(nums.length+1)/2;
        System.out.println(fin);
        if(fin<ans2){
            return ans2-fin;
        }




        return fin-ans2;

        
        
    }
}