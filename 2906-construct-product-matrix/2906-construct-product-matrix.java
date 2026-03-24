class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        List<Integer>sing=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                sing.add(grid[i][j]);
            }
        }
        List<Integer>prefix=new ArrayList<>();
        List<Integer>rev=new ArrayList<>();
        prefix.add(1);

        for(int i=0;i<sing.size()-1;i++){
            int pre = (int)((long)sing.get(i) * prefix.get(i) % 12345);
            prefix.add(pre);
          
        }
        rev.add(1);
        int count=0;

        
        for(int i=sing.size()-1;i>=0;i--){
            int pro = (int)((long)sing.get(i) * rev.get(count) % 12345);
            rev.add(pro);
            count++;
        }
        List<Integer>suffix=new ArrayList<>();
        for(int i=rev.size()-2;i>=0;i--){
            suffix.add(rev.get(i));
        }
        System.out.println(prefix);
        System.out.println(suffix);
        List<Integer>fins=new ArrayList<>();
        for(int i=0;i<prefix.size();i++){
            int vals = (int)((long)prefix.get(i) * suffix.get(i) % 12345);
            fins.add(vals);

        }
        int checks=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                grid[i][j]=fins.get(checks);
                checks++;

            }
        }
    
        
        return grid;
    }
}