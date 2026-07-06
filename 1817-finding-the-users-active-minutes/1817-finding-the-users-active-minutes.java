class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
       
        HashMap<Integer,HashSet<Integer>>maps=new HashMap<>();
        for(int[]log:logs){
            int first=log[0];
            int second=log[1];
            if(!maps.containsKey(first)){
                HashSet<Integer>sets=new HashSet<>();
                sets.add(second);
                maps.put(first,sets);
            }
            else{
            HashSet<Integer>set=maps.get(first);
            set.add(second);
            maps.put(first,set);
            }

        }
        ArrayList<Integer>lis=new ArrayList<Integer>(maps.keySet());
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<lis.size();i++){
            int val=maps.get(lis.get(i)).size();
            if(map.containsKey(val)){
                int adds=map.get(val);
                adds++;
                map.put(val,adds);
            }
            else{
                map.put(val,1);
            }
        }
        System.out.println(map);
        HashMap<Integer,Integer>map1=new HashMap<>();
        List<Integer>vals=new ArrayList<>(map.keySet());
        for(int i=0;i<vals.size();i++){
            
            if(map1.containsKey(vals.get(i))){
                int values=map1.get(vals.get(i));
                values++;
                map1.put(vals.get(i),values);
            }
            else{
                map1.put(vals.get(i),map.get(vals.get(i)));
            }
        }
        System.out.println(map1);
        int[]ans;
        ans=new int[k];

        for(int i=0;i<ans.length;i++){
            if(map1.containsKey(i+1)){
                int val=map1.get(i+1);
                ans[i]=val;

            }
            else{
                ans[i]=0;

            }
        }
        return ans;
    }
}