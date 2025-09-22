class Solution {
    public int singleNumber(int[] nums) {
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
        for(int i=0;i<nums.length;i++){
            int val=map.get(nums[i]);
            if(val==1){
                return nums[i];
            }
        }
        return -1;
    }
}