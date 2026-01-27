class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int subsets=(int)Math.pow(2,nums.length);
        List<List<Integer>>ans=new ArrayList<>();

        List<String>bin=new ArrayList<>();
        for(int i=0;i<subsets;i++){
            String binar=Integer.toBinaryString(i);
            StringBuilder str=new StringBuilder(binar);
            if(str.length()!=nums.length){
                str.reverse();
                int val=nums.length-str.length();
                for(int j=0;j<val;j++){
                    str.append('0');
                }
                str.reverse();
            }
            bin.add(str.toString());

        }
   

        for(String sing:bin){
            List<Integer>addon=new ArrayList<>();
            for(int i=0;i<sing.length();i++){
                if(sing.charAt(i)=='1'){
                    addon.add(nums[i]);

                }
            }
            
                ans.add(addon);

            
            
        }
 
        int max=0;

        for(List<Integer>single:ans){
            int value=0;
            for(int i=0;i<single.size();i++){
                value=value| single.get(i);
                
            }
            max=Math.max(max,value);


        }
        int count=0;
        for(List<Integer>single:ans){
            int value=0;
            for(int i=0;i<single.size();i++){
                value=value| single.get(i);
                
            }
            if(max==value){
                count++;
            }


        }
     
        return count;
        
    }
}