class Solution {
    public String processStr(String s) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                str.append(s.charAt(i));
            }
            else if(s.charAt(i)=='#'){
                String addon=new String(str.toString());
                str.append(addon);
            }
            else if(s.charAt(i)=='%'){
                str.reverse();
            }
            else{
                if(str.length()>0){
                    str.deleteCharAt(str.length()-1);
                    
                }
                
            }
        }
        return str.toString();
    }
}