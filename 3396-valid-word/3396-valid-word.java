class Solution {
    public boolean isValid(String word) {
        
        int vow=0;
        int cons=0;
        for(int i=0;i<word.length();i++){
            if(Character.isDigit(word.charAt(i))){
                continue;
            }
            else if(Character.isLetter(word.charAt(i))){
                if(word.charAt(i)=='a' || word.charAt(i)=='e' ||word.charAt(i)=='i' ||word.charAt(i)=='o' ||word.charAt(i)=='u' ||word.charAt(i)=='A'||word.charAt(i)=='E'||word.charAt(i)=='I'||word.charAt(i)=='O'||word.charAt(i)=='U'){
                    vow++;
                   
                }
                else{
                    cons++;
                   
                }
            }
            else{
                return false;
            }
        }
        if(word.length()>=3 && vow>=1 && cons>=1  ){
            return true;
        }
        return false;
    }
}