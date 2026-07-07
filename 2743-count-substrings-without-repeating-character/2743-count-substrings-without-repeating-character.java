class Solution {
    public int numberOfSpecialSubstrings(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int count=0;
        int left=0;
        int right=0;
        while(left<=right && right<s.length()){
            if(map.containsKey(s.charAt(right))){
                int val=map.get(s.charAt(right));
                val++;
                map.put(s.charAt(right),val);
            }
            else{
               map.put(s.charAt(right),1);
               
            }
            int sz=right-left+1;
            while((right-left+1)>map.size()){
                int val1=0;
                if(map.containsKey(s.charAt(left))){
                    int vals=map.get(s.charAt(left));
                    val1=vals;

                }
                
                val1--;
                if(val1==0){
                    map.remove(s.charAt(left));
                }
                else{
                    map.put(s.charAt(left),val1);
                }
                left++;
          
            }
            int fin=right-left+1;
            if(fin==map.size()){
                count=count+(right-left+1);
            }
            right++;
            
        }
       
        return count;

        
    }
}