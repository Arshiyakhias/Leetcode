class Solution {
    public int maximum69Number (int num) {
        StringBuffer str=new StringBuffer();
        str.append(num);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='9'){
                continue;
            }
            else{
                str.delete(i,i+1);
                str.insert(i,'9');
                break;
            }
        }
        String val=str.toString();
        int ans=Integer.parseInt(val);
        return ans;
    }
}