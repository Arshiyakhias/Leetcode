class Solution {
    public void dfs(int num,List<List<Integer>>adj,List<Boolean>visited){
        visited.set(num,true);
        List<Integer>neighbours=adj.get(num);
        System.out.println(neighbours);
        for(int i=0;i<neighbours.size();i++){
            if(visited.get(neighbours.get(i))!=true){
                visited.set(neighbours.get(i),true);
                dfs(neighbours.get(i),adj,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int len=isConnected.length;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            List<Integer>lis=new ArrayList<>();

            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1){
                    lis.add(j);
                }



            }
            adj.add(lis);
        }
        List<Boolean>visited=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            visited.add(false);

        }
        int count=0;


        for(int i=0;i<isConnected.length;i++){
            if(visited.get(i)!=true){
                dfs(i,adj,visited);
                count++;
            }

        }
        //System.out.println(adj);
        return count;
        
    }
}