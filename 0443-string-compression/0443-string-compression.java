class Solution {
    public int compress(char[] chars) {
      String s=new String();
      char check=chars[0];
      int count=1;

    


      for(int i=1;i<chars.length;i++){
        if(check==chars[i]){
            count++;
            check=chars[i];
        }
        else{
            
            s=s+check;
            if(count!=1){
                s=s+count;

            }
            
            check=chars[i];
            count=1;

        }
      }
      s=s+check;
      if(count!=1){
        s=s+count;

      }
      
      if(chars.length<=1){
        return chars.length;
      }
      for(int i=0;i<s.length();i++){
        chars[i]=s.charAt(i);
      }
      return s.length();
       
    }
}