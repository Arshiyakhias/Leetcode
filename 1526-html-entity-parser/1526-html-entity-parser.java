class Solution {
    public String entityParser(String text) {
        HashMap<String,Character>map=new HashMap<>();
        map.put("&quot;",'"');
        map.put("&apos;",'\'');
        map.put("&amp;",'&');
        map.put("&gt;",'>');
        map.put("&lt;",'<');
        map.put("&frasl;",'/');
      
        String ans=new String();
        StringBuilder find=new StringBuilder();
        Boolean flag=false;
        

        for(int i=0;i<text.length();i++){
            if(text.charAt(i)=='&'){
               
                    ans=ans+find.toString();
                    find.setLength(0);
                    find.append(text.charAt(i));
               
                
                flag=true;
            }
            else if(text.charAt(i)==';'){
                
                find.append(text.charAt(i));
                if(map.containsKey(find.toString())){
                    ans=ans+map.get(find.toString());

                }
                else{
                    ans=ans+find.toString();
                }
                
                
                find.setLength(0);
                flag=false;
             

                
            }
            else if (flag==true){
                
                find.append(text.charAt(i));
            }
            else{
                ans=ans+text.charAt(i);
            }
            

        }
        ans=ans+find.toString();
        return ans;

    }
}