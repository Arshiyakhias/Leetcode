class Solution {
    public int[] getNoZeroIntegers(int n) {
        ArrayList<Integer>lis=new ArrayList<>();
        for(int i=1;i<n;i++){
            String check=new String();
            check=check+i;
            if(check.contains("0")){
                continue;
            }
            else{
                lis.add(i);

            }
            
        }
        int[]ans;
        ans=new int[2];
        int left=0;
        int right=lis.size()-1;
        while(left<=right){
            int sum=lis.get(left)+lis.get(right);
            if(sum==n){
                ans[0]=lis.get(left);
                ans[1]=lis.get(right);
                break;
            }
            else if(sum<=n){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
}