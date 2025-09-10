class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int val=map.get(nums[i]);
                val++;
                map.put(nums[i],val);
            }
            else{
                map.put(nums[i],1);
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]-1) && !map.containsKey(nums[i]+1) && map.get(nums[i])==1 ){
                ans.add(nums[i]);

            }
        }
        return ans;
    }
}