class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer>lis=new ArrayList<>();
        for(int i=0;i<bank.length;i++){
            int count=0;
            for(int j=0;j<bank[i].length();j++){
                if(bank[i].charAt(j)=='1'){
                    count++;
                }
            }
            if(count!=0){
                 lis.add(count);

            }
           

        }
        System.out.println(lis);
        int ans=0;
        if(lis.size()<=1){
            return ans;
        }
        for(int i=0;i<lis.size()-1;i++){
            int val=lis.get(i)*lis.get(i+1);
            ans=ans+val;
        }
        return ans;
    }
}