class Solution {
 public int countIslands(int[][] grid, int k) {
     int count=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]>=1){
                   long val=dfs(grid,i,j); 
                    if(val%k==0){
                        count++;
                        
                    }
                }
            }
        }
     return count;
    }
    public long dfs(int[][]grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 ){
            return 0;
        }
        long current=grid[i][j];
        
        grid[i][j]=0;
        long sum=current;
        sum=sum+dfs(grid,i+1,j);
        sum=sum+dfs(grid,i-1,j);
        sum=sum+dfs(grid,i,j+1);
        sum=sum+dfs(grid,i,j-1);
        return sum;
    }
}