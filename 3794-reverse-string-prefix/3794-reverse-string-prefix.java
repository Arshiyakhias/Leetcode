class Solution {
    public String reversePrefix(String s, int k) {
        String[]arr=s.split("");
        String ans=new String();
        if(k<arr.length ){
            for(int i=k-1;i>=0;i--){
               
                ans=ans+arr[i];
            }
            for(int i=k;i<arr.length;i++){
                ans=ans+arr[i];
            }
             
            
        }
        else{
            StringBuilder str=new StringBuilder(s);
            str.reverse();
            ans=ans+str.toString();
        }
        return ans;
    }
}