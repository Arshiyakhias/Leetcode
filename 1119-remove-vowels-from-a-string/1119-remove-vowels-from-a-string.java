class Solution {
    public String removeVowels(String s) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' ||s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u'  ){
                continue;
            }
            else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}