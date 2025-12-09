class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int count=0;
        int distinct=set.size();
       

        for(int i=0;i<nums.length;i++){
            List<Integer>temp=new ArrayList<>();
            HashSet<Integer>set1=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                temp.add(nums[j]);
                set1.add(nums[j]);
                if(set1.size()==distinct){
                    count++;
                }
                
                
            }
        }


      
       
        return count;
    }
}