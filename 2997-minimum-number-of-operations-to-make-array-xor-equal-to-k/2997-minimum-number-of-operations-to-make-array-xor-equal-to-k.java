class Solution {
    public int minOperations(int[] nums, int k) {
        
        List<String>lis=new ArrayList<>();
        String fin=Integer.toBinaryString(k);
        int max=fin.length();
        
        for(int i=0;i<nums.length;i++){
            String addon=Integer.toBinaryString(nums[i]);
            lis.add(addon);
            max=Math.max(max,addon.length());
        }

        for(int i=0;i<lis.size();i++){
            if(lis.get(i).length()!=max){
                StringBuilder str=new StringBuilder(lis.get(i));
                str.reverse();
                int val=max-lis.get(i).length();
                for(int j=0;j<val;j++){
                    str.append('0');
                }
                str.reverse();
                lis.set(i,str.toString());
            }
        }
        String fins=Integer.toBinaryString(k);
        String fins1=new String();
        if(fins.length()!=max){
            StringBuilder str=new StringBuilder(fins);
            str.reverse();
            int vals=max-fins.length();
            for(int i=0;i<vals;i++){
                str.append('0');

            }
            str.reverse();
            fins1=fins1+str.toString();

        }
        else{
            fins1=fins1+fins;
        }
        System.out.println(fins1);

        System.out.println(lis);
        int val1=nums[0];
        for(int i=1;i<nums.length;i++){
            val1=val1^nums[i];
        }
        int ans=0;
        String nums_xor=Integer.toBinaryString(val1);
        System.out.println(nums_xor);
        String nums_xor1=new String();

        if(nums_xor.length()!=max){
            StringBuilder str=new StringBuilder(nums_xor);
            str.reverse();
            int vals=max-nums_xor.length();
            for(int i=0;i<vals;i++){
                str.append('0');

            }
            str.reverse();
            nums_xor1=nums_xor1+str.toString();

        }
        else{
            nums_xor1=nums_xor1+nums_xor;
        }
        for(int i=0;i<fins1.length();i++){
            if(fins1.charAt(i)!=nums_xor1.charAt(i)){
                ans++;
                
            }
        }


        return ans;
    }
}