class NumArray {
    List<Integer>lis=new ArrayList<>();

    public NumArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(lis.isEmpty()){
                lis.add(nums[i]);
            }
            else{
                int val=lis.get(i-1);
                int adds=val+nums[i];
                lis.add(adds);
            }
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return lis.get(right);
        }
        return lis.get(right)-lis.get(left-1);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */