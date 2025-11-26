class Solution {
    public int reverseDegree(String s) {
      HashMap<Character,Integer>map=new HashMap<>();
      int value=26;
      for(char i='a';i<='z';i++){
        System.out.println(i);
        map.put(i,value);
        value--;

      } 
      int ans=0; 
      

      for(int i=0;i<s.length();i++){
        int vals=map.get(s.charAt(i));
        vals=vals*(i+1);
        ans=ans+vals;
      }
      return ans;
    }
}