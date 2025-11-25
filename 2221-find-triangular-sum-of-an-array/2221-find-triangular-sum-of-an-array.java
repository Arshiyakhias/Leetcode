class Solution {
    public int triangularSum(int[] nums) {
        List<Integer>lis=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            lis.add(nums[i]);
        }
        while(lis.size()>1){
            for(int i=0;i<lis.size()-1;i++){
                int val=(lis.get(i)+lis.get(i+1))%10;
                lis.set(i,val);
                
           
            }
            lis.remove(lis.size()-1);
        }

        return lis.get(0);

        
    }
}