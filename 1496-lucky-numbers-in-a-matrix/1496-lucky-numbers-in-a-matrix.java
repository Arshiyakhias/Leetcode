class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer>row=new ArrayList<>();
        List<Integer>col=new ArrayList<>();
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            int min=Integer.MAX_VALUE;

            for(int j=0;j<matrix[i].length;j++){
                min=Math.min(min,matrix[i][j]);

            }
            row.add(min);
            System.out.println(min);
            set.add(min);
        }
        List<Integer>ans=new ArrayList<>();

        for(int i=0;i<matrix[0].length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<matrix.length;j++){
                max=Math.max(max,matrix[j][i]);

            }
            col.add(max);
            System.out.println(max);
            if(set.contains(max)){
                ans.add(max);
            }
        }
     
        
       
        return ans;
    }
}