class Solution {
    private String int_to_bin(int a){
        if(a==0){
            return "0";
        }
        StringBuilder ans=new StringBuilder();
        while(a!=1){
            ans.append(a%2);
            a=a/2;

        }
        ans.append("1");
        ans.reverse();
        return ans.toString();
    }
    private String balance(int max_len,String a){

        StringBuilder str=new StringBuilder(a);
        str.reverse();


        
        if(max_len>a.length()){
            for(int i=0;i<(max_len-a.length());i++){
                str.append("0");
            }
        }
        str.reverse();
        return str.toString();

    }
    public int minFlips(int a, int b, int c) {
        String bina=int_to_bin(a);
        String binb=int_to_bin(b);

        int val=a | b;
        String val_bin=int_to_bin(val);
        String c_bin=int_to_bin(c);

        
      
        int max_len=Math.max(val_bin.length(),c_bin.length());
        max_len=Math.max(max_len,bina.length());
        max_len=Math.max(max_len,binb.length());

        String bina_append=balance(max_len,bina);
        String binb_append=balance(max_len,binb);
        String val_bin_append=balance(max_len,val_bin);
        String c_append=balance(max_len,c_bin);
        int count=0;

        for(int i=0;i<c_append.length();i++){
            if(c_append.charAt(i)!=val_bin_append.charAt(i)){
                if(val_bin_append.charAt(i)=='0'){
                    count++;
                }
                else{
                    if(bina_append.charAt(i)=='1' && binb_append.charAt(i)=='1'){
                        count=count+2;
                    }
                    else{
                        count++;
                    }
                }
            }
        }
        return count;




       



       
        
    }
}