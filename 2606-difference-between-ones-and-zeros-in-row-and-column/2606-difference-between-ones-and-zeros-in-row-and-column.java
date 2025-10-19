class Solution {
    public int[][] onesMinusZeros(int[][] grid) {

        List<Integer>onesRow=new ArrayList<>();
        List<Integer>zerosRow=new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            int zero=0;
            int one=0;
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    zero++;
                }
                if(grid[i][j]==1){
                    one++;
                }

            }
            onesRow.add(one);
            zerosRow.add(zero);
            
        }

        List<Integer>onesCol=new ArrayList<>();
        List<Integer>zerosCol=new ArrayList<>();

        for(int i=0;i<grid[0].length;i++){
            int one=0;
            int zero=0;
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==0){
                    zero++;
                }
                if(grid[j][i]==1){
                    one++;
                }

            }
            onesCol.add(one);
            zerosCol.add(zero);
            
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                
                grid[i][j]=onesRow.get(i)-zerosRow.get(i)+onesCol.get(j)-zerosCol.get(j);
            }
        }
        return grid;

        

        
    }
}