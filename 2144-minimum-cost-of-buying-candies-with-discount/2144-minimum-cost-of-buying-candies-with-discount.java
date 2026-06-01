class Solution {
    public int minimumCost(int[] cost) {
        ArrayList<Integer>lis=new ArrayList<Integer>();
        for(int i=0;i<cost.length;i++){
            lis.add(cost[i]);
        }
        Collections.sort(lis,Collections.reverseOrder());
        int count=0;
        int sum=0;
        for(int i=0;i<lis.size();i++){
            count++;
            if(count<3){
                sum=sum+lis.get(i);
            }
            if(count==3){
                count=0;
            }
        }
        return sum;
        
    }
}