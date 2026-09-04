class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k==1 ){
            return nums;
        }
        
        List<List<Integer>>fin=new ArrayList<>();
        for(int i=0;i<(nums.length-k+1);i++){
            List<Integer>addon=new ArrayList<>();

            for(int j=i;j<(i+k);j++){
                addon.add(nums[j]);
               

            }
            fin.add(addon);
            System.out.println(addon);
         


        }

        List<Integer>ans=new ArrayList<>();
        for(List<Integer>sing:fin){
            Boolean flag=false;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<sing.size()-1;i++){
                max=Math.max(max,sing.get(i));
                max=Math.max(max,sing.get(i+1));
                if(sing.get(i)+1==sing.get(i+1)){
                    flag=true;
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                ans.add(max);
            }
            else{
                ans.add(-1);
            }
        }
        int[]fins;
        fins=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            fins[i]=ans.get(i);
        }
        return fins;
       
    }
}