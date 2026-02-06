class Solution {
    public int[][] diagonalSort(int[][] grid) {
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        int m=grid.length;
        List<Integer>lis1=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int val=m+j-i;
                lis1.add(val);
                if(map.containsKey(val)){
                    
                    map.get(val).add(grid[i][j]);
                }
                else{
                    List<Integer>lis=new ArrayList<>();
                    lis.add(grid[i][j]);
                    map.put(val,lis);
                }
            }
        }
        HashMap<Integer,List<Integer>>fin=new HashMap<>();
        for(int i=0;i<lis1.size();i++){
            List<Integer>gen=map.get(lis1.get(i));
            if(gen.size()>=1){
                Collections.sort(gen);
                fin.put(lis1.get(i),gen);
                
            }
            
            
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int val=m+j-i;
                int find=fin.get(val).get(0);
                fin.get(val).remove(0);
                grid[i][j]=find;
            }
        }
        return grid;
        
    }
}