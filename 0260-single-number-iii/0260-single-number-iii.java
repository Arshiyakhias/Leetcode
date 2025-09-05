class Solution {
    public int[] singleNumber(int[] nums) {
        ArrayList<Integer>check=new ArrayList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(check.contains(nums[i]) ){
                if(ans.contains(nums[i])){
                    ans.remove(Integer.valueOf(nums[i]));
                }
              
                check.add(nums[i]);
            }
            else{
                check.add(nums[i]);
                ans.add(nums[i]);
            }
        }
        int[]fin;
        fin=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            fin[i]=ans.get(i);
        }
        return fin;
    }
}