class Solution {
    public List<String> letterCasePermutation(String s) {
        int chars=0;
        String without_num=new String();

        List<String>ans=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                chars++;
                without_num=without_num+s.charAt(i);
            }
        }
        if(chars==0){
            ans.add(s);
            return ans;
        }
        int subsets=(int)Math.pow(2,chars);
        List<String>lis=new ArrayList<>();
        for(int i=0;i<subsets;i++){
            String bin=Integer.toBinaryString(i);
            StringBuilder str=new StringBuilder(bin);
            if(str.length()!=chars){
                str.reverse();
                int val=chars-str.length();
                for(int j=0;j<val;j++){
                    str.append('0');
                }
                str.reverse();
            }
            lis.add(str.toString());
        }
        List<String>fin=new ArrayList<>();

        for(String sing:lis){
            String addon=new String();
            for(int i=0;i<sing.length();i++){
                
                if(sing.charAt(i)=='1'){
                    char vals=without_num.charAt(i);
                    if(Character.isLowerCase(vals)){
                        char adds=Character.toUpperCase(vals);
                        addon=addon+adds;

                    }
                    else{
                        char adds=Character.toLowerCase(vals);
                        addon=addon+adds;

                    }
                    
             


                }
                else{
                    char vals=without_num.charAt(i);
                 
                    addon=addon+vals;

                }
            }
            fin.add(addon);
        }

        for(String fina:fin){
            String addson=new String();
            int count=0;

            for(int i=0;i<s.length();i++){
                if(Character.isLetter(s.charAt(i))){
                    
                    addson=addson+fina.charAt(count);
                    count++;

                }
                else{
                    addson=addson+s.charAt(i);

                }
            }
            ans.add(addson);
        }


        System.out.println(lis);
        System.out.println(fin);
        return ans;
    }
}