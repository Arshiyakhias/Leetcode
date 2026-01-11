class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>>res=new ArrayList();
        res.add(new ArrayList());
        for(int num:nums){
            int n=res.size();
            for(int j=0;j<n;j++){
                List<Integer>temp=new ArrayList(res.get(j));
                temp.add(num);
                res.add(temp);
            }
        }
        int sum=0;
        for(List<Integer>arr:res){
            int xor=0;
            for(int i=0;i<arr.size();i++){
                xor=xor^arr.get(i);

            }
            sum=sum+xor;
        }
        return sum;
    }
}