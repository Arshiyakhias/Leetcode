class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0){
            return 0;
        }
        PriorityQueue<Integer>greed=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer>size=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<g.length;i++){
            greed.add(g[i]);
        }
        for(int i=0;i<s.length;i++){
            size.add(s[i]);
        }
        int ans=0;
        while(!greed.isEmpty() && !size.isEmpty()){
            int gr=greed.poll();
            int si=size.poll();
            
            if(gr<=si){
                ans++;
            }
            else{
                size.add(si);
            }
        }
        return ans;
    }
}