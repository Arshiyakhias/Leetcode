class Solution {
    public String decodeMessage(String key, String message) {
        System.out.println(key);
        HashMap<Character,Character>map=new HashMap<>();
        HashSet<Character>set=new HashSet<>();
        String key1=new String();
        for(int i=0;i<key.length();i++){
            if(set.contains(key.charAt(i))){
                continue;
            }
            else{
                key1=key1+key.charAt(i);
                set.add(key.charAt(i));

            }
        }
        System.out.println(key1);
        int index=0;
        for(char i='a';i<='z';i++){
            if(key1.charAt(index)==' '){
                index++;
                map.put(key1.charAt(index),i);
             
                index++;
            }
            else{
                map.put(key1.charAt(index),i);
               
                index++;
            }
           
            
            

        }
        String ans=new String();

        


        for(int i=0;i<message.length();i++){
            if(map.containsKey(message.charAt(i))){
                char vals=map.get(message.charAt(i));
                ans=ans+vals;

            }
            else{
                ans=ans+' ';
            }
            
        }
        return ans;
    }
}