class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer>lis=new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            lis.add(i);
        }
        int index=0;
        while(lis.size()!=1){
            
                index=(index+(k-1))%lis.size();//this is creating a circular list 
                lis.remove(index);
            
        }
        return lis.get(0);
    }
}