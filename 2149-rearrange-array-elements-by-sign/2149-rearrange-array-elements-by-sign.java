class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer>pos=new ArrayList<>();
        ArrayList<Integer>neg=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }
        int[]ans;
        ans=new int[nums.length];
        int index=0;
        for(int i=0;i<pos.size();i++){
            ans[index]=pos.get(i);
            index++;
            ans[index]=neg.get(i);
            index++;
        }
        return ans;
    }
}