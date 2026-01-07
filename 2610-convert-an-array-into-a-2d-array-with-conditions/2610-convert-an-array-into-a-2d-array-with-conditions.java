class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int val=map.get(nums[i]);
                val++;
                map.put(nums[i],val);
                max=Math.max(max,val);
            }
            else{
                map.put(nums[i],1);
                max=Math.max(max,1);
            }
        }
        List<List<Integer>>lis=new ArrayList<>();
        for(int i=0;i<max;i++){
            List<Integer>addon=new ArrayList<>();
       
            lis.add(addon);

        }
        HashMap<Integer,Integer>map1=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map1.containsKey(nums[i])){
                int val1=map1.get(nums[i]);
                lis.get(val1).add(nums[i]);
                val1++;
                
                map1.put(nums[i],val1);
            }
            else{
                map1.put(nums[i],1);
                lis.get(0).add(nums[i]);

            }
        }
        return lis;

    }

}