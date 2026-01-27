class Solution {
    public List<String> validStrings(int n) {
        int num=(int)Math.pow(2,n);
        List<String>lis=new ArrayList<>();
        for(int i=0;i<num;i++){
            String bin=Integer.toBinaryString(i);
            StringBuilder str=new StringBuilder(bin);
            str.reverse();
            int find=n-str.length();
            if(str.length()!=n){
                for(int j=0;j<find;j++){
                    str.append('0');

                }
            }
            str.reverse();
            lis.add(str.toString());

        }

        List<String>fin=new ArrayList<>();
      
        for(String sing:lis){
            Boolean flag=false;
            int index=-1;

            for(int i=0;i<sing.length();i++){
                if(sing.charAt(i)=='0' && index!=-1){
                    if(Math.abs(index-i)==1){
                        flag=true;
                        break;
                    }

                }
                if(sing.charAt(i)=='0'){
                    index=i;
                }
            }
            if(flag==false){
                fin.add(sing);
            }

        }
        return fin;

    }
}