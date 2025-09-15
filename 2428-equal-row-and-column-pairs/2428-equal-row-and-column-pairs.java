class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>,Integer>map=new HashMap<>();
        
        int count=0;
        for(int i=0;i<grid.length;i++){
            List<Integer>addon=new ArrayList<>();
            for(int j=0;j<grid[i].length;j++){
                addon.add(grid[j][i]);

            }
            if(map.containsKey(addon)){
                int val=map.get(addon);
                val++;
                map.put(addon,val);
            }
            else{
                map.put(addon,1);
            }
            
        }
        for(int i=0;i<grid.length;i++){
            List<Integer>lis=new ArrayList<>();
            for(int j=0;j<grid[i].length;j++){
                lis.add(grid[i][j]);

            }
            if(map.containsKey(lis)){
                int val=map.get(lis);
                count=count+val;
            }
        }
        return count;
    }
}