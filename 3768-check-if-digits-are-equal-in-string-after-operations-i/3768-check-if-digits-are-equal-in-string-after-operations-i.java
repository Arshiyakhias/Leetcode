class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder str=new StringBuilder(s);
        while(str.length()>2){
            String addon=new String();

            for(int i=0;i<str.length()-1;i++){
                int char1=Character.getNumericValue(str.charAt(i));
                int char2=Character.getNumericValue(str.charAt(i+1));
                char1=char1+char2;
                char1=char1%10;
                addon=addon+char1;

            }
            str.delete(0,str.length());
            str.append(addon);

        }
        if(str.charAt(0)==str.charAt(1)){
            return true;
        }
        return false;
    }
}