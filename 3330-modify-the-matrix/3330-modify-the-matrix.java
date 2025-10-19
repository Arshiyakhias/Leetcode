class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        List<Integer>col=new ArrayList<>();
        for(int i=0;i<matrix[0].length;i++){
            int max=Integer.MIN_VALUE;

            for(int j=0;j<matrix.length;j++){
                max=Math.max(max,matrix[j][i]);


            }
            col.add(max);
        }

        for(int i=0;i<matrix.length;i++){
            

            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=col.get(j);
                }


            }
        }
        return matrix;
    }
}