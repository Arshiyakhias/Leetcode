class Solution {
    public int shareCandies(int[] candies, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<candies.length;i++){
            if(map.containsKey(candies[i])){
                int val=map.get(candies[i]);
                val++;
                map.put(candies[i],val);
            }
            else{
                map.put(candies[i],1);
            }
        }
      
        
        for(int i=0;i<k;i++){
            if(map.containsKey(candies[i])){
                int vals=map.get(candies[i]);
                vals--;
                if(vals==0){
                    map.remove(candies[i]);

                }
                else{
                    map.put(candies[i],vals);

                }
               
                
            }
           
        }
        int max=map.size();
        for(int i=1;i<=candies.length-k;i++){
            
            if(map.containsKey(candies[i-1])){
                int val=map.get(candies[i-1]);
                val++;
                map.put(candies[i-1],val);
            }
            else{
                map.put(candies[i-1],1);
            }

            int vals=map.get(candies[i+k-1]);
            vals--;
            if(vals==0){
                map.remove(candies[i+k-1]);
            }
            else{
                map.put(candies[i+k-1],vals);
            }
            max=Math.max(max,map.size());

            

        }
        return max;
       
    }
}