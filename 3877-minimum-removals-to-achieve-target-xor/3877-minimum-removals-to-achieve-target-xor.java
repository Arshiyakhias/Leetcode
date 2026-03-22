class Solution {
    public int minRemovals(int[] nums, int target) {
        HashMap<Integer,Integer>dp=new HashMap<>();

        dp.put(0,0);
        for(int i=0;i<nums.length;i++){
            HashMap<Integer,Integer>copy=new HashMap<>(dp);
            for(int x: dp.keySet()){
                int new_num=x^nums[i];
                int new_size=dp.get(x)+1;
                if(dp.containsKey(new_num)){
                    int val=copy.get(new_num);
                    int fin=Math.max(val,new_size);
                    copy.put(new_num,fin);
                }
                else{
                    copy.put(new_num,new_size);
                }
                

                            }
                            dp=copy;


        }
        if(dp.containsKey(target)){
            return nums.length-(int)dp.get(target);
        }
        return -1;

    }
}