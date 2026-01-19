class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer>lis=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0){
                lis.add(i);
            }
        }
        Collections.sort(lis);
        if(lis.size()<k){
            return -1;
        }
        return lis.get(k-1);
    }
}