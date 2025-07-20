class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String ans=new String();
        ans=ans+x;
        StringBuffer str=new StringBuffer(ans);
        str.reverse();
        if(ans.equals(str.toString())){
            return true;
        }
        return false;


        
    }
}