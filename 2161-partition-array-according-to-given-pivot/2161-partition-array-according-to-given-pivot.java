class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer>less=new ArrayList<Integer>();
        ArrayList<Integer>same=new ArrayList<Integer>();
        ArrayList<Integer>great=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                less.add(nums[i]);
            }
            if(nums[i]>pivot){
                great.add(nums[i]);
            }
            if(nums[i]==pivot){
                same.add(nums[i]);
            }
        }
        int[]ans;
        ans=new int[nums.length];
        int index=less.size();
        for(int i=0;i<less.size();i++){
            ans[i]=less.get(i);
        }
        for(int i=0;i<same.size();i++){
            ans[index]=same.get(i);
            index++;

        }
        for(int i=0;i<great.size();i++){
            ans[index]=great.get(i);
            index++;
            
        }
        return ans;
    }
}