class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
     ArrayList<Integer>lis=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[i].length;j++){
                sum=sum+mat[i][j];

            }
            lis.add(i);
           
            map.put(i,sum);

            
        }
        Collections.sort(

            lis,(a,b)->Integer.compare(map.get(a),map.get(b))
        );
        int[]ans;
        ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=lis.get(i);
        }
        return ans;
    }
}