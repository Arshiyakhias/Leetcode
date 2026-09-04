class Solution {
    public int firstStableIndex(int[] nums, int k) {
        List<Integer>max=new ArrayList<>();
        List<Integer>min=new ArrayList<>();
        int maxx=nums[0];
        int minn=nums[nums.length-1];

        max.add(maxx);
        for(int i=1;i<nums.length;i++){
            int val=Math.max(max.get(i-1),nums[i]);
            max.add(val);
            

        }
        min.add(minn);
        int index=0;

        for(int i=nums.length-2;i>=0;i--){
            int vals=Math.min(min.get(index),nums[i]);
            min.add(vals);
            index++;
        }

        int count=0;
        for(int i=min.size()-1;i>=0;i--){
          
            int check=max.get(count)-min.get(i);
            
            if(check<=k){
                return count;
            }
            count++;
        }
        return -1;
  


    }
}