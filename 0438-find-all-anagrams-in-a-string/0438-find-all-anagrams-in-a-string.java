class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       int k=p.length();
       
       List<Integer>ans=new ArrayList<>();
       if(s.length()<p.length()){
        return ans;
       }
      String check=s.substring(0,k);
    
       StringBuilder str=new StringBuilder(check);
       HashMap<Character,Integer>map=new HashMap<>();
       for(int i=0;i<p.length();i++){
        if(map.containsKey(p.charAt(i))){
            int val=map.get(p.charAt(i));
            val++;
            map.put(p.charAt(i),val);
        }
        else{
            map.put(p.charAt(i),1);
        }
       }
       
        HashMap<Character,Integer>map1=new HashMap<>();
       for(int i=0;i<check.length();i++){
        if(map1.containsKey(check.charAt(i))){
            int val1=map1.get(check.charAt(i));
            val1++;
            map1.put(check.charAt(i),val1);
        }
        else{
            map1.put(check.charAt(i),1);
        }
       }
       if(map.equals(map1)){
        ans.add(0);
       }

       int l=0;
       int r=k-1;
       while(r<s.length()-1){
        if(map1.containsKey(s.charAt(l))){
            int values=map1.get(s.charAt(l));
            values--;
            if(values==0){
                map1.remove(s.charAt(l));
            }
            else{
                map1.put(s.charAt(l),values);

            }
            
        }
        
        str.delete(0,1);
        l++;
        r++;
        str.append(s.charAt(r));
        //System.out.println(str);
        if(map1.containsKey(s.charAt(r))){
            int values1=map1.get(s.charAt(r));
            values1++;
            
            map1.put(s.charAt(r),values1);
        }
        else{
            map1.put(s.charAt(r),1);
        }
        //System.out.println(map1);

        if(map.equals(map1)){
            ans.add(l);
        }

        


       }
  
       return ans;
       
       


       
    }
}