class Solution {
    public String stringHash(String s, int k) {
        ArrayList<String>arr=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        int count=0;
        
        for(int i=0;i<s.length();i++){
            if(count<k){
                str.append(s.charAt(i));
                count++;
            }
            if(count==k){
                arr.add(str.toString());
                str.delete(0,str.length());
                //str.append(s.charAt(i));
                count=0;
                
              
            }

        }
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
       
        HashMap<Character,Integer>map=new HashMap<>();
        HashMap<Integer,Character>map1=new HashMap<>();
        int val=0;

        for(char i='a';i<='z';i++){
            
            map.put(i,val);
            map1.put(val,i);
            val++;
        }
      

        String ans=new String();
        for(String single:arr){
            int fin=0;
            for(int i=0;i<single.length();i++){
                fin=fin+map.get(single.charAt(i));
            }
            fin=fin%26;
            System.out.println(fin);
            ans=ans+map1.get(fin);

            
        }
        return ans;

    }
}