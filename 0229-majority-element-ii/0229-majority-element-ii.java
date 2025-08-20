class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        
       
        for(int num:nums){
            if(map.containsKey(num)){
                int val=map.get(num);
                val++;
                map.put(num,val);
            }
            else{
                map.put(num,1);
            }
            
        }
        List<Integer>lis=new ArrayList<>(map.keySet());
        Collections.sort(lis,(a,b)->
        Integer.compare(map.get(b),map.get(a)));
        int check=nums.length/3;
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<lis.size();i++){
            if(map.get(lis.get(i))>check){
                ans.add(lis.get(i));
            }
        }
        return ans;


    }
}