class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<operations.length;i++){
            if(map.containsKey(operations[i][0])){
                int val=map.get(operations[i][0]);
                map.remove(operations[i][0]);
                map.put(operations[i][1],val);
            }
        }
        ArrayList<Integer>lis=new ArrayList<>(map.keySet());
        Collections.sort(lis,(a,b)->
        Integer.compare(map.get(a),map.get(b))
        );
        int[]ans;
        ans=new int[lis.size()];
        for(int i=0;i<lis.size();i++){
            ans[i]=lis.get(i);
        }
        return ans;
    }
}