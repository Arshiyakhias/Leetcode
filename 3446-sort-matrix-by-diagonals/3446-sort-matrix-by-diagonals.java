class Solution {
    public int[][] sortMatrix(int[][] grid) {
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        int m=grid.length;
        List<Integer>fin=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int val=m+j-i;
                if(map.containsKey(val)){
                    
                    
                    map.get(val).add(grid[i][j]);
                }
                else{
                    fin.add(val);
                    List<Integer>lis=new ArrayList<>();
                    lis.add(grid[i][j]);
                    map.put(val,lis);
                }
            }
        }
      

        for(int i=0;i<fin.size();i++){
            int vals=fin.get(i);
            if(vals<=m){
                List<Integer>lis1=map.get(vals);
                Collections.sort(lis1);

                List<Integer>addon=new ArrayList<>();
                for(int j=lis1.size()-1;j>=0;j--){
                    addon.add(lis1.get(j));
                }
                map.remove(vals);
                map.put(vals,addon);
                
            }
            else{
                List<Integer>lis1=map.get(vals);
                Collections.sort(lis1);

              
                map.remove(vals);
                map.put(vals,lis1);
            }
        }
        System.out.println(map);

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int val=m+j-i;
                grid[i][j]=map.get(val).get(0);
                List<Integer>lis2=map.get(val);
                lis2.remove(0);
                map.remove(val);
                map.put(val,lis2);
            }
        }
        return grid;

    }
}