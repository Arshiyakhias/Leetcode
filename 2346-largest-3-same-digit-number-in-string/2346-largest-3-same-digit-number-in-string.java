class Solution {
    public String largestGoodInteger(String num) {
        String res="0";
        for(int i=0;i<num.length()-2;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2)){
                if(Integer.parseInt(res)<=Integer.parseInt(num.substring(i,i+3))){
                    res=num.substring(i,i+3);
                }
                

            }
            
        }
        if(res.equals("0")){
            return "";
        }
        return res;
    }
}