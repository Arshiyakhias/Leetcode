class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>pre=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer>lis=new ArrayList<>();
            
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    lis.add(1);
                }
                else{
                    lis.add(pre.get(j-1)+pre.get(j));
                    
                }
            }
            pre=lis;
            result.add(lis);
        }
        return result;
    }
}