class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean>lis=new ArrayList<Boolean>();
        int start=0;
        
        for(int i=0;i<nums.length;i++){
            start=(start<<1)+nums[i];
            start=start%5;
            if(start%5==0){
                lis.add(true);
            }
            else{
                lis.add(false);
            }
        }
        return lis;
    }
}