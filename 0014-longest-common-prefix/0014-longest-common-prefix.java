class Solution {
    public String longestCommonPrefix(String[] strs) {
        String check="";
        String res=new String();
        if(strs.length==1){
            return strs[0];
        }
        for(int i=0;i<strs[0].length();i++){
            check=check+strs[0].charAt(i);
            int k=0;
            for(int j=1;j<strs.length;j++){

                if(strs[j].startsWith(check)){
                    k++;
                    if(k==strs.length-1){
                        res=res+strs[0].charAt(i);
                    }
                    
                }
                else{
                    break;

                }
            }
        }
        return res;
    }
}