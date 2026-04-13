class Solution {

    
    public int maxAreaOfIsland(int[][] grid) {
        int area=0;
    
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[i].length;j++){
            if(grid[i][j]==1){
                
                int val=dfs(grid,i,j);
                area=Math.max(area,val);
            }
        }
       }
       return area; 
    }

    public int dfs(int[][]grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0){
            return 0;
        }
        int current=grid[i][j];
        grid[i][j]=0;
        int sum=current;
        sum=sum+dfs(grid,i+1,j);
        sum=sum+dfs(grid,i-1,j);
        sum=sum+dfs(grid,i,j+1);
        sum=sum+dfs(grid,i,j-1);
        return sum;
    }
}