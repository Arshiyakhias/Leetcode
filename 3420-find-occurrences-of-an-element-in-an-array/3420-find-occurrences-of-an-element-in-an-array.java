class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                count++;
                map.put(count,i);
            }
        }
        for(int i=0;i<queries.length;i++){
            if(map.containsKey(queries[i])){
                queries[i]=map.get(queries[i]);
            }
            else{
                queries[i]=-1;
            }
        }
        return queries;
    }
}