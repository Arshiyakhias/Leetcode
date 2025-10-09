class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<score.length;i++){
            map.put(i,score[i][k]);
            
        }

        List<Integer>lis=new ArrayList<>(map.keySet());
        Collections.sort(lis,(a,b)->
        Integer.compare(map.get(b),map.get(a))
        );
        int[][]ans;
        ans=new int[score.length][score[0].length];
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                ans[i][j]=score[lis.get(i)][j];
            }
        }
        return ans;
    }
}