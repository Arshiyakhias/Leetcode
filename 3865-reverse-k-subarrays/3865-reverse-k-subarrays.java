class Solution {
    public int[] reverseSubarrays(int[] nums, int k) {
        List<List<Integer>>lis=new ArrayList<>();
        int siz=nums.length/k;
       
        List<Integer>addon=new ArrayList<>();
        int count=0;
        

        for(int i=0;i<nums.length;i++){
            if(count<siz){
                addon.add(nums[i]);
                count++;
            }
            else if(count==siz){
                List<Integer>adds=new ArrayList<>(addon);
                
                lis.add(adds);
                count=0;
                addon.clear();
                
                addon.add(nums[i]);
                count=1;
            }
           
        }
        lis.add(addon);
        int s=0;
        List<List<Integer>>ans=new ArrayList<>();
        for(List<Integer>sing:lis){
            List<Integer>ad=new ArrayList<>();
            for(int i=sing.size()-1;i>=0;i--){
                ad.add(sing.get(i));
                s++;

            }
           
            ans.add(ad);
        }
        int[]an;
        an=new int[s];
        int ind=0;
        for(List<Integer>sings:ans){
            
            for(int i=0;i<sings.size();i++){
                an[ind]=sings.get(i);
                ind++;

            }
           
    
        }

    
        return an;


        
    }
}