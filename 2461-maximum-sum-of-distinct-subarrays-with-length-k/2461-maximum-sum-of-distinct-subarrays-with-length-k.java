class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if(nums.length<k){
            return 0;
        }
        int count=0;
        long sum=0;
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<k;i++){
         
            if(map.containsKey(nums[i])){
                int val=map.get(nums[i]);
                val++;
                map.put(nums[i],val);
            }
            else{
                map.put(nums[i],1);
            }
            sum=sum+nums[i];
        }
        long max=0;
        if(map.size()==k){
            max=sum;
          
        }
       
        
      
        int l=0;
        int r=k-1;
    
        while(r<nums.length-1){
            sum=sum-nums[l];
            if(map.containsKey(nums[l])){
                int vals=map.get(nums[l]);
                vals--;
                if(vals==0){
                    map.remove(nums[l]);
                }
                else{
                    map.put(nums[l],vals);
                }
            }
            l++;
            r++;
            sum=sum+nums[r];
            if(map.containsKey(nums[r])){
                int vals1=map.get(nums[r]);
                vals1++;
                map.put(nums[r],vals1);
            }
            else{
                map.put(nums[r],1);
            }
         
            if(map.size()==k){
                max=Math.max(max,sum);
                System.out.println(max);
            }
         
        }
        return max;

    }
}