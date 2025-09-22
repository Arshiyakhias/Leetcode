class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int value=map.get(nums[i]);
                value++;
                map.put(nums[i],value);
            }
            else{
                map.put(nums[i],1);
            }
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            int value=map.get(nums[i]);
            max=Math.max(max,value);

        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(max==map.get(nums[i])){
                count=count+1;

            }
        }
        
        return count;

    }
}