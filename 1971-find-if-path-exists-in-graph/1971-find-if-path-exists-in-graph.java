class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer>sing=new ArrayList<>();
            adj.add(sing);
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        //ArrayList<Integer>lis=new ArrayList<>();
        ArrayList<Boolean>visited=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            visited.add(false);
        }
        q.add(source);
        while(!q.isEmpty()){
            int vals=q.size();
            while(vals>0){
                int curr=q.poll();
                
               
                for(int i=0;i<adj.get(curr).size();i++){
                    
                    if(visited.get(adj.get(curr).get(i))!=true){
                        q.add(adj.get(curr).get(i));
                        visited.set(adj.get(curr).get(i),true);

                    }
                    if(adj.get(curr).get(i)==destination){
                        return true;
                    }
                }
                if(curr==destination){
                    return true;
                }
              
                vals--;
            }
        }
        return false;
    }
}