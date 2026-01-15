class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        List<List<Integer>>lis=new ArrayList<>();

        for(int i=0;i<groupSizes.length;i++){
            if(map.containsKey(groupSizes[i])){
                map.get(groupSizes[i]).add(i);
            }
            else{
                List<Integer>addon=new ArrayList<>();
                addon.add(i);
                map.put(groupSizes[i],addon);
            }
        }
        List<Integer>num=new ArrayList<>(map.keySet());

        for(int nums:num){
            List<Integer>fin=map.get(nums);
            
            if(fin.size()<=nums){
                lis.add(fin);
                
            }
            else{
                
                List<Integer>adds=new ArrayList<>();
                
                for(int i=0;i<fin.size();i++){
                    if(adds.size()<nums){
                        adds.add(fin.get(i));
                        
                    }
                    else{
                        ArrayList<Integer>fins=new ArrayList<>(adds);
                        lis.add(fins);
                        
                        adds.clear();
                        
                        adds.add(fin.get(i));
                        
                    }
                   
                    
                    
                }
                lis.add(adds);
               
                
            }

        }
        
        return lis;
    }
}