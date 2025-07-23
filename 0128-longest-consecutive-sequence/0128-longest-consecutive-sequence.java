class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer>set=new HashSet<>();
       for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
       } 
       int max=0;
       for(int num:set){
        if(set.contains(num-1)){
            continue;
        }
        else{
            int count=0;
            int num1=num;
            while(set.contains(num1)){
                num1++;
                count++;
            }
            max=Math.max(max,count);
        }
       }
       return max;
    }
}