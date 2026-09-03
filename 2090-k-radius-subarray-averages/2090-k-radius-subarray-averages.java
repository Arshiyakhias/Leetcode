class Solution {
    public int[] getAverages(int[] nums, int k) {
        int k_copy=k;
        k=k+k+1;
        long sum=0;
        int[]ans;
        ans=new int[nums.length];
        if(k>nums.length){
            for(int i=0;i<nums.length;i++){
                ans[i]=-1;
            }
            return ans;
        }
        else if(k_copy==0){
            for(int i=0;i<nums.length;i++){
                ans[i]=nums[i];
            }
            return ans;
        }
        else if(nums.length==1){
            return nums;
        }
        System.out.println(nums.length);
      
        for(int i=0;i<k;i++){
            sum=sum+nums[i];

        }
        int index=k/2;
        ans[index]=(int)(sum/k);
        int min=index;
        //System.out.println(index);
        int max=index;
        index++;
        for(int i=1;i<(nums.length-k+1);i++){
            sum=sum-nums[i-1];
            sum=sum+nums[i+k-1];
            ans[index]=(int)(sum/k);
            index++;
            max=Math.max(max,index);
        }
        System.out.println(min+" "+max);
        System.out.println();
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
        if(min==max){
            for(int i=0;i<ans.length;i++){
            if(i!=min){
                ans[i]=-1;
            }
        }
        return ans;
        }

        for(int i=0;i<ans.length;i++){
            if(i<min || i>=max){
                ans[i]=-1;
            }
        }
        return ans;
        
        
    }
}