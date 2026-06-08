class Solution {
    public String reverseOnlyLetters(String s) {
        int left=0;
        int right=s.length()-1;
        StringBuilder str=new StringBuilder(s);
        while(left<right){
            if(Character.isLetter(str.charAt(left)) && Character.isLetter(str.charAt(right)) ){
                char lef=str.charAt(left);
                char righ=str.charAt(right);
                str.setCharAt(left,righ);
                str.setCharAt(right,lef);
                right--;
                left++;
            }
            else if(Character.isLetter(str.charAt(left)) && !Character.isLetter(str.charAt(right)) ){
                right--;
            }
            else if(!Character.isLetter(str.charAt(left)) && Character.isLetter(str.charAt(right)) ){

                left++;
            }
            else{
                left++;
                right--;
            }

        }
        return str.toString();
    }
}