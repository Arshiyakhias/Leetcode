class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
      HashMap<Character,Integer>map=new HashMap<>();
      int count=0;
      for(int i=0;i<allowed.length();i++){
        map.put(allowed.charAt(i),1);
      }
      for(String word:words){
        for(int j=0;j<word.length();j++){
            if(map.containsKey(word.charAt(j))){
                continue;
            }
            else{
                count=count+1;
                break;
            }
        }
        
      }
      int ans=words.length-count;
      return ans;

        
    }
}