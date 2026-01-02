class Solution {
    public int repeatedNTimes(int[] nums) {
        int leng=nums.length;
        int count=leng/2;
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
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int check=map.get(nums[i]);
            if(count==check){
                ans=nums[i];
                break;
                
            }
        }
        return ans;

    }
}