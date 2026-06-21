class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
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
        }
        List<Integer>lis=new ArrayList<>();
        lis.add(map.size());
      
        for(int i=1;i<nums.length-k+1;i++){
            int val=map.get(nums[i-1]);
            val--;
            if(val==0){
                map.remove(nums[i-1]);
            }
            else{
                map.put(nums[i-1],val);
            }
            if(map.containsKey(nums[i+k-1])){
                int vals=map.get(nums[i+k-1]);
                vals++;
                map.put(nums[i+k-1],vals);
            }
            else{
                map.put(nums[i+k-1],1);
            }
            lis.add(map.size());
            
        }
        int[]ans;
        ans=new int[lis.size()];
        for(int i=0;i<lis.size();i++){
            ans[i]=lis.get(i);
        }
        return ans;
    }
}