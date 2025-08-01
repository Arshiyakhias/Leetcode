class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int max=nums[nums.length-1];
        if(max<0){
            max=0;
        }
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=1;i<=max;i++){
            if(set.contains(i)){
                continue;
            }
            else{
                return i;
            }
        }
        return max+1;

    }
}